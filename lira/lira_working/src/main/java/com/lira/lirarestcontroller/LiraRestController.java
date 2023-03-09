package com.lira.lirarestcontroller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.lira.entity.Department;
import com.lira.entity.EMReport;
import com.lira.entity.Employee;
import com.lira.entity.Experiment;
import com.lira.entity.InputFile;
import com.lira.entity.FMReport;
import com.lira.entity.Group;
import com.lira.entity.Organization;
import com.lira.entity.Project;
import com.lira.entity.ProjectComments;
import com.lira.entity.PyeReport;
import com.lira.entity.RecReport;
import com.lira.entity.SelecReport;
import com.lira.securityconfig.ConfigProperties;
import com.lira.service.DeptService;
import com.lira.service.EmployeeService;
import com.lira.service.GroupService;
import com.lira.service.OrgService;
import com.lira.service.ProjectCommentsService;
import com.lira.service.ProjectService;
import com.lira.service.InputFileStorageService;
import com.lira.service.PyeReportService;
import com.lira.service.EMReportService;
import com.lira.service.FMReportService;
import com.lira.service.RecReportService;
import com.lira.service.SelecReportService;
import com.lira.service.ExperimentService;

@RestController
@RequestMapping("/lira")

public class LiraRestController {
	
	private EmployeeService empService;
	private OrgService orgService;
	private DeptService deptService;
	private GroupService groupService;
	private ProjectService projectService;
	private InputFileStorageService inputFileStorageService;
	private ProjectCommentsService projectCommentsService;
	private PyeReportService pyeReportService;
	private EMReportService emReportService;
	private FMReportService fmReportService;
	private RecReportService recReportService;
	private SelecReportService selecReportService;
	private ExperimentService experimentService;
	
	
	private String empRole;
	private String empName;
	private int empId;
	private int proj_todo_cnt;
	private int proj_inprogress_cnt;
	private int proj_archived_cnt;
	private int proj_cancelled_cnt;
	@PersistenceContext
    private EntityManager em;
	@Autowired
	ConfigProperties configProp;
	
	public LiraRestController(EmployeeService theEmpService, OrgService theOrgService, DeptService theDeptService, GroupService theGroupService, ProjectService theProjectService, ProjectCommentsService theProjectCommentsService, 
			PyeReportService thePyeReportService, EMReportService theEMReportService, FMReportService theFMReportService,
			RecReportService theRecReportService, ExperimentService theExperimentService,
			SelecReportService theSelecReportService, InputFileStorageService theInputFileStorageService) {
			
			empService = theEmpService;
			orgService = theOrgService;
			deptService = theDeptService;
			groupService = theGroupService;
			projectService =theProjectService;
			projectCommentsService =theProjectCommentsService;
			pyeReportService = thePyeReportService;
			emReportService = theEMReportService;
			fmReportService = theFMReportService;
			recReportService = theRecReportService;
			selecReportService = theSelecReportService;
			experimentService = theExperimentService;
			inputFileStorageService = theInputFileStorageService;
	}
	
	@GetMapping("login")
	public ModelAndView login(Model model) {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("login");
	    return mav;
    }
	
	@GetMapping("experimentsHome")
	public ModelAndView experimentsHome(Model model) {
		
	    ModelAndView mav = new ModelAndView();
	    Experiment experiment = new Experiment();
	    PyeReport pyereport = new PyeReport();
	    EMReport emreport = new EMReport();
	    FMReport fmreport = new FMReport();
	    RecReport recreport = new RecReport();
	    SelecReport selecreport = new SelecReport();
	    
	    mav.setViewName("experimentsHome");
	    List<Project> projects = projectService.findAll();
	    model.addAttribute("projects", projects);
	    model.addAttribute("experiment", experiment);
	    model.addAttribute("pyereport", pyereport);
	    model.addAttribute("emreport", emreport);
	    model.addAttribute("fmreport", fmreport);
	    model.addAttribute("recreport", recreport);
	    model.addAttribute("selecreport", selecreport);
	    return mav;
    }
	
	@GetMapping("welcome")
	public ModelAndView welcome(Model model, Principal principal) {
		System.out.println("going to welcome page");
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		String userName = principal.getName();
        System.out.println("User Name: " + userName);
        TypedQuery<Employee> queries = em.createNamedQuery(Employee.QUERY_FIND_USER,Employee.class).setParameter("userName", userName);
        employee=queries.getSingleResult();
        proj_todo_cnt = projectService.findByStatus("todo").size();
        proj_inprogress_cnt = projectService.findByStatus("inprogress").size();
        proj_archived_cnt = projectService.findByStatus("archived").size();
        proj_cancelled_cnt = projectService.findByStatus("cancelled").size();
        model.addAttribute("proj_todo_cnt", proj_todo_cnt);
        model.addAttribute("proj_inprogress_cnt", proj_inprogress_cnt);
        model.addAttribute("proj_archived_cnt", proj_archived_cnt);
        model.addAttribute("proj_cancelled_cnt", proj_cancelled_cnt);
        ModelAndView mav = new ModelAndView();
        if(employee !=null) {
        //Employee emp=employeeService.loadUserByUsername(userName);
        empName =employee.getFirstName()+" "+employee.getLastName();
        empId =employee.getEmpId();
        System.out.println("empId::::: " + empId);
        empRole=employee.getRole();
        System.out.println("empRole: " + empRole);
        model.addAttribute("empName", empName);
        
        model.addAttribute("empRole", empRole);
        if(empRole.equalsIgnoreCase("USER")) {
        	
        	mav.setViewName("welcome");
        }else if (empRole.equalsIgnoreCase("HOD")) {
        	
        	List<Project> projects = projectService.findAll();
        	List<Employee> employees = empService.findAll();
        	HashMap<Integer,String> empIdNamelist = new HashMap<>();
    		for(int i=0; i<employees.size(); i++) {
    			String name = null;
    			int id;
    			id=employees.get(i).getEmpId();
				name = employees.get(i).getFirstName()+" "+employees.get(i).getLastName();
				empIdNamelist.put(id,name);
    		}
    		System.out.println("in findAll of LimsRestController --- ");
    		Project newProject = new Project();
    		System.out.println("empName  in welcome1 page----"+empName);
    		// add to the spring model
    		model.addAttribute("empIdNamelist",empIdNamelist);
    		model.addAttribute("newProject", newProject);
    		model.addAttribute("projects", projects);
    		mav.setViewName("welcome1");
        	
        }
        
        System.out.println("empId ::::"+ employee.getEmpId());
       
	    
        }
	    return mav;
    }
	
	@GetMapping("listuser")
	public ModelAndView listuser(Model theModel) {
		System.out.println("in LiRaRestController listuser method.");
//		return empService.findAll();
		
		ModelAndView mav = new ModelAndView();
		List<Employee> employees = empService.findAll();
		System.out.println("in findAll of listuser --- ");
		theModel.addAttribute("empName", empName);
		System.out.println("empName  in welcome1 page----"+empName);
		// add to the spring model
		theModel.addAttribute("proj_todo_cnt", proj_todo_cnt);
		theModel.addAttribute("proj_inprogress_cnt", proj_inprogress_cnt);
		theModel.addAttribute("proj_archived_cnt", proj_archived_cnt);
		theModel.addAttribute("proj_cancelled_cnt", proj_cancelled_cnt);
		theModel.addAttribute("employees", employees);
		mav.setViewName("listuser");
		return mav;
    }
	
	@GetMapping("listOrg")
	public ModelAndView listOrg(Model theModel) {
		System.out.println("in LiRaRestController listOrg method.");
//		return empService.findAll();
		
		ModelAndView mav = new ModelAndView();
		List<Organization> orgs = orgService.findAllOrg();
		System.out.println("in findAll of listOrg --- ");
		theModel.addAttribute("empName", empName);
		System.out.println("empName  in welcome1 page----"+empName);
		// add to the spring model
		theModel.addAttribute("orgs", orgs);
		mav.setViewName("listOrg");
		return mav;
    }
	
	@GetMapping("projectListWithStatus")
	public ModelAndView projectListWithStatus(@RequestParam("status") int theStatus,Model theModel,Principal principal) {
		ModelAndView mav = new ModelAndView();
		List<Project> projects = null;
		if(theStatus == 1)
			projects = projectService.findByStatus("todo");
		else if(theStatus == 2)
			projects = projectService.findByStatus("inprogress");
		else if(theStatus == 3)
		projects = projectService.findByStatus("archived");
		else if(theStatus == 4)
			projects = projectService.findByStatus("cancelled");
		System.out.println("in findByStatus of listproject --- ");
		theModel.addAttribute("userName", principal.getName());
		System.out.println("empName  in listproject page----"+empName);
		// add to the spring model
		theModel.addAttribute("proj_todo_cnt", proj_todo_cnt);
		theModel.addAttribute("proj_inprogress_cnt", proj_inprogress_cnt);
		theModel.addAttribute("proj_archived_cnt", proj_archived_cnt);
		theModel.addAttribute("proj_cancelled_cnt", proj_cancelled_cnt);
		theModel.addAttribute("projects", projects);
		theModel.addAttribute("empName", empName);
		
		
		mav.setViewName("listProject");
		return mav;
	}
	
	@GetMapping("listDept")
	public ModelAndView listDept(Model theModel) {
		System.out.println("in LiRaRestController listDept method.");
//		return empService.findAll();
		
		ModelAndView mav = new ModelAndView();
		List<Department> depts = deptService.findAllDept();
		System.out.println("in findAll of listOrg --- ");
		theModel.addAttribute("empName", empName);
		System.out.println("empName  in welcome1 page----"+empName);
		// add to the spring model
		theModel.addAttribute("depts", depts);
		mav.setViewName("listDept");
		return mav;
    }
	
	@GetMapping("listGroup")
	public ModelAndView listGroup(Model theModel) {
		System.out.println("in LiRaRestController listDept method.");
//		return empService.findAll();
		
		ModelAndView mav = new ModelAndView();
		List<Group> groups = groupService.findAllGroup();
		System.out.println("in findAll of listGroup --- ");
		theModel.addAttribute("empName", empName);
		System.out.println("empName  in welcome1 page----"+empName);
		// add to the spring model
		theModel.addAttribute("groups", groups);
		mav.setViewName("listGroup");
		return mav;
    }
	
	@GetMapping("/showusercreateform")
	public ModelAndView adduser(Model model) {
	    System.out.println("calling adduser page");
		Employee emp=new Employee();
		model.addAttribute("employee", emp);
		model.addAttribute("empName", empName);
	    
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("createuser");
	    return mav;
    }
	
	@GetMapping("/showOrgCreateForm")
	public ModelAndView addOrg(Model model) {
	    System.out.println("calling addOrg page");
	    Organization org=new Organization();
		model.addAttribute("org", org);
		model.addAttribute("empName", empName);
		
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("createOrg");
	    return mav;
    }
	
	@GetMapping("/showDeptCreateForm")
	public ModelAndView addDept(Model model) {
	    System.out.println("calling addDept page");
	    Department dept=new Department();
		model.addAttribute("dept", dept);
		model.addAttribute("empName", empName);
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("createDept");
	    return mav;
    }
	
	@GetMapping("/showGroupCreateForm")
	public ModelAndView addGroup(Model model) {
	    System.out.println("calling addDept page");
	    Group group=new Group();
		model.addAttribute("group", group);
		model.addAttribute("empName", empName);
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("createGroup");
	    return mav;
    }
	
	@PostMapping("/saveemployee")
	public RedirectView addEmployee(@ModelAttribute("Employee") Employee theEmployee) {
		System.out.println(" adding user");
		System.out.println("saveEmployee-- theEmployee.getEmpId()---"+ theEmployee.getEmpId());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(theEmployee.getEmpId() == 0) {
			
		}else {
			System.out.println("saveEmployee-- theEmployee.getEmpId()---"+ theEmployee.getEmpId());
				theEmployee.setEmpId(theEmployee.getEmpId());
		}
		theEmployee.setPassword("$2y$12$I42o/QungSNSqPNpkdqSjei1uSQCnycAPPzIQgzf7L3AqaC8dchna");
		theEmployee.setDeptId(1);
		theEmployee.setOrgId(1);
		theEmployee.setCreatedBy(empId);
		System.out.println("empid in addEmployee method----"+empId);
		theEmployee.setCreatedDate(formatter.format(calendar.getTime()));
		theEmployee.setModifiedBy(empId);
		System.out.println("empid in addEmployee method----"+empId);
		theEmployee.setModifiedDate(formatter.format(calendar.getTime()));
		
		empService.save(theEmployee);
		return new RedirectView("/lira/listuser");
	}
	
	@PostMapping("/saveOrg")
	public RedirectView saveOrg(@ModelAttribute("Organization") Organization theOrganization) {
		System.out.println(" adding org");
		System.out.println("saveOrg-- theOrganization.getOrgId()---"+ theOrganization.getOrgId());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(theOrganization.getOrgId() ==null) {
			
		}else {
			System.out.println("saveOrg-- theOrganization.getOrgId---"+ theOrganization.getOrgId());
			theOrganization.setOrgId(theOrganization.getOrgId());
			
		}
		//theOrganization.setOrgId("1");
		//	theEmployee.setCreatedBy(OrgId);
//		System.out.println("empid in addEmployee method----"+empId);
//		theEmployee.setCreatedDate(formatter.format(calendar.getTime()));
//		theEmployee.setModifiedBy(empId);
//		System.out.println("empid in addEmployee method----"+empId);
//		theEmployee.setModifiedDate(formatter.format(calendar.getTime()));
		
		orgService.saveOrg(theOrganization);
		return new RedirectView("/lira/listOrg");
	}
	
	@PostMapping("/saveDept")
	public RedirectView addDept(@ModelAttribute("Department") Department theDepartment) {
		System.out.println(" adding theDepartment");
		System.out.println("savetheDepartment-- theDepartment.getEmpId()---"+ theDepartment.getDeptId());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(theDepartment.getDeptId() == null) {
			
		}else {
			System.out.println("savetheDepartment-- theDepartment.getDeptId()---"+ theDepartment.getDeptId());
			theDepartment.setDeptId(theDepartment.getDeptId());
		}
		
		
//		theDepartment.setOrgId(1);
//		theDepartment.setCreatedBy(empId);
//		System.out.println("empid in addEmployee method----"+empId);
//		theDepartment.setCreatedDate(formatter.format(calendar.getTime()));
//		theDepartment.setModifiedBy(empId);
//		System.out.println("empid in addEmployee method----"+empId);
//		theDepartment.setModifiedDate(formatter.format(calendar.getTime()));
		
		deptService.saveDept(theDepartment);
		return new RedirectView("/lira/listDept");
	}
	
	@PostMapping("/saveGroup")
	public RedirectView addGroup(@ModelAttribute("Group") Group theGroup) {
		System.out.println(" adding theGroup");
		System.out.println("savetheGroup-- theGroup.getEmpId()---"+ theGroup.getGroupId());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(theGroup.getGroupId() == null) {
			
		}else {
			System.out.println("savetheDepartment-- theGroup.getGroupId()---"+ theGroup.getGroupId());
			theGroup.setGroupId(theGroup.getGroupId());
		}
		
		
//		theGroup.setOrgId(1);
//		theGroup.setCreatedBy(empId);
//		System.out.println("empid in addEmployee method----"+empId);
//		theGroup.setCreatedDate(formatter.format(calendar.getTime()));
//		theGroup.setModifiedBy(empId);
//		System.out.println("empid in addEmployee method----"+empId);
//		theGroup.setModifiedDate(formatter.format(calendar.getTime()));
		
		groupService.saveGroup(theGroup);
		return new RedirectView("/lira/listGroup");
	}
	
	@GetMapping("/showFormForUpdate")
	public ModelAndView showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel ) {
		
		Employee employee = empService.findById(theId);
		if(employee == null) {
			throw new RuntimeException ("employee id not found - " +theId);
		}
		theModel.addAttribute("employee", employee);
		theModel.addAttribute("empName", empName);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("createuser");
	    return mav;
		
	}
	
	@GetMapping("/showFormForUpdateOrg")
	public ModelAndView showFormForUpdateOrg(@RequestParam("orgId") String theOrgId, Model theModel ) {
		System.out.println("in showFormForUpdateOrg--"+theOrgId);
		Organization org = orgService.findByOrgId(theOrgId);
		if(org == null) {
			throw new RuntimeException ("org id not found - " +theOrgId);
		}
		theModel.addAttribute("org", org);
		theModel.addAttribute("empName", empName);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("createOrg");
	    return mav;
		
	}
	
	@GetMapping("/showFormForUpdateDept")
	public ModelAndView showFormForUpdateDept(@RequestParam("deptId") String theDeptId, Model theModel ) {
		System.out.println("in showFormForUpdateDept--"+theDeptId);
		Department dept = deptService.findByDeptId(theDeptId);
		if(dept == null) {
			throw new RuntimeException ("dept id not found - " +theDeptId);
		}
		theModel.addAttribute("dept", dept);
		theModel.addAttribute("empName", empName); 
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("createDept");
	    return mav;
		
	}
	
	@GetMapping("/showFormForUpdateGroup")
	public ModelAndView showFormForUpdateGroup(@RequestParam("groupId") String theGroupId, Model theModel ) {
		System.out.println("in showFormForUpdateGroup--"+theGroupId);
		Group group = groupService.findByGroupId(theGroupId);
		if(group == null) {
			throw new RuntimeException ("dept id not found - " +theGroupId);
		}
		theModel.addAttribute("group", group);
		theModel.addAttribute("empName", empName);	 
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("createGroup");
	    return mav;
		
	}
	
	@GetMapping("/deleteemp")
	public RedirectView deleteEmp(@RequestParam("employeeId") int theId ) {
		
		Employee employee = empService.findById(theId);
		
		if(employee == null) {
			throw new RuntimeException ("employee id not found - " +theId);
		}
		empService.deleteById(theId);
		 
		return new RedirectView("/lira/listuser");
		
	}
	
	@GetMapping("/deleteProject")
	public RedirectView deleteProject(@RequestParam("proj_id") int theId ) {
		System.out.println("in deleteProject--- "+theId);
		
		Project project = projectService.findById(theId);
		
		if(project == null) {
			throw new RuntimeException ("project id not found - " +theId);
		}
		projectService.deleteById(theId);
		
		return new RedirectView("/lira/welcome");
		
	}
	
	@GetMapping("/deleteOrg")
	public RedirectView deleteOrg(@RequestParam("orgId") String theId ) {
		
		Organization org = orgService.findByOrgId(theId);
		
		if(org == null) {
			throw new RuntimeException ("employee id not found - " +theId);
		}
		orgService.deleteByOrgId(theId);
		 
		return new RedirectView("/lira/listOrg");
		
	}
	
	@GetMapping("/deleteDept")
	public RedirectView deleteDept(@RequestParam("deptId") String theId ) {
		
		Department dept = deptService.findByDeptId(theId);
		
		if(dept == null) {
			throw new RuntimeException ("employee id not found - " +theId);
		}
		deptService.deleteByDeptId(theId);
		 
		return new RedirectView("/lira/listDept");
		
	}
	
	@GetMapping("/deleteGroup")
	public RedirectView deleteGroup(@RequestParam("groupId") String theId ) {
		
		Group group = groupService.findByGroupId(theId);
		
		if(group == null) {
			throw new RuntimeException ("group id not found - " +theId);
		}
		groupService.deleteByGroupId(theId);
		 
		return new RedirectView("/lira/listGroup");
		
	}
	
	/*@GetMapping("listProject")
	public ModelAndView listProject(Model theModel, Principal principal) {
		System.out.println("in LiRaRestController listproject method.");
//		return empService.findAll();
		
		ModelAndView mav = new ModelAndView();
		List<Project> projects = projectService.findAll();
		System.out.println("in findAll of listproject --- ");
		theModel.addAttribute("userName", principal.getName());
		System.out.println("empName  in listproject page----"+empName);
		// add to the spring model
		theModel.addAttribute("projects", projects);
		mav.setViewName("listProject");
		return mav;
    }
	
	
	@GetMapping("showProjectCreateForm")
		public ModelAndView addProject(Model model) {
		    System.out.println("calling addProject page");
			Project project=new Project();
			model.addAttribute("project", project);
			HashMap<Integer,String> GrpLeaderList = empService.findByRole("groupleader");
			HashMap<Integer,String> CoordinatorList = empService.findByRole("coordinator");
			HashMap<Integer,String> QAList = empService.findByRole("QA");
			HashMap<Integer,String> QCList = empService.findByRole("QC");
		    
		    model.addAttribute("GrpLeaderList", GrpLeaderList);
		    model.addAttribute("CoordinatorList", CoordinatorList);
		    model.addAttribute("QAList", QAList);
		    model.addAttribute("QCList", QCList);
		    
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("createProject");
		    return mav;
	    }
	
	
	@PostMapping("/saveproject")
	public RedirectView addProject(@ModelAttribute("Project") Project theProject) {
		System.out.println(" adding project");
		System.out.println("saveproject-- theProject.getProjectId()---"+ theProject.getProj_id());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(theProject.getProj_id() == null) {
			
		}else {
			System.out.println("saveProject-- int NOT NULL AUTO_INCREMENT,.getProjectId()---"+ theProject.getProj_id());
			theProject.setProj_id(theProject.getProj_id());
		}
		System.out.println("description in saveproject" +theProject.getDescription());
		
		theProject.setCoordinatorId(5);
		theProject.setCoordinator("test5");
		theProject.setGpLeaderId(3);
		theProject.setGrpLeader("test3");
		theProject.setQaId(7);
		theProject.setQA("test7");
		theProject.setQcId(9);
		theProject.setQC("test9");
		theProject.setCreatedBy(empId);
		System.out.println("empid in saveproject method----"+empId);
		theProject.setCreatedDate(formatter.format(calendar.getTime()));
		theProject.setModifiedBy(empId);
		System.out.println("empid in saveproject method----"+empId);
		theProject.setModifiedDate(formatter.format(calendar.getTime()));
		
		projectService.save(theProject);
		return new RedirectView("/lira/listProject");
	}
	
	
	@GetMapping("listProjectComments")
	public ModelAndView listProjectComments(@RequestParam("projectId") String theId, Model theModel ) {
		System.out.println("in LiRaRestController listProjectComments method.");
//		return empService.findAll();
		Project project = projectService.findById(theId);
		String projectName=project.getProj_name();
		
		ModelAndView mav = new ModelAndView();
		List<ProjectComments> projectComments = projectCommentsService.findById(theId);
		System.out.println("in findAll of listProjectComments --- ");
		theModel.addAttribute("empName", empName);
		System.out.println("empName  in listProjectComments page----"+empName);
		// add to the spring model
		theModel.addAttribute("projectComments", projectComments);
		theModel.addAttribute("projectName", projectName);
		mav.setViewName("listProjectComments");
		return mav;
    }
	
	@GetMapping("showFormForProjectReport")
		public ModelAndView showFormForProjectReport(Model model) {
	    System.out.println("calling createProjectReport page");
		//ProjectReportDetails projectReportDetails=new ProjectReportDetails();
		//model.addAttribute("ProjectReportDetails", projectReportDetails);
	    JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("input", "rawData” : tmp/sgsg.csv");
        employeeDetails.put("type", "Pye");
        employeeDetails.put("output", " parameter : /tmp/agag.json, image: /tmp/agag.jpg,  type: QC");
         
        JSONObject employeeObject = new JSONObject(); 
        employeeObject.put("employee", employeeDetails);
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        try (FileWriter file = new FileWriter("employees.json")) {
        	 
            file.write(employeeList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	    ModelAndView mav = new ModelAndView();
	    model.addAttribute("JsonEmployee", employeeDetails);
	    mav.setViewName("showFormForProjectReport");
	    return mav;
	
	
	}
	
	@GetMapping("projectDetails")
	public ModelAndView projectDetails(@RequestParam("projectId") String theId, Model theModel ) {
		System.out.println("in LiRaRestController projectDetails method.");
		ModelAndView mav = new ModelAndView();
		
		Project project = projectService.findById(theId);
		theModel.addAttribute("project", project);
		mav.setViewName("projectDetails");
		return mav;
		
	}*/
	
	@GetMapping("listProject")
	public ModelAndView listProject(Model theModel, Principal principal) {
		System.out.println("in LiRaRestController listproject method.");
//		return empService.findAll();
		
		ModelAndView mav = new ModelAndView();
		List<Project> projects = projectService.findAll();
		System.out.println("in findAll of listproject --- ");
		theModel.addAttribute("userName", principal.getName());
		System.out.println("empName  in listproject page----"+empName);
		// add to the spring model
		theModel.addAttribute("proj_todo_cnt", proj_todo_cnt);
		theModel.addAttribute("proj_inprogress_cnt", proj_inprogress_cnt);
		theModel.addAttribute("proj_archived_cnt", proj_archived_cnt);
		theModel.addAttribute("proj_cancelled_cnt", proj_cancelled_cnt);
		theModel.addAttribute("empName", empName);
		theModel.addAttribute("projects", projects);
		mav.setViewName("listProject");
		return mav;
    }
	
	@PostMapping("listProject")
	public ModelAndView listProject(@ModelAttribute("proj_comments") ProjectComments theProjectComments,@ModelAttribute("project") Project theProject,Model theModel,Principal principal) {
		System.out.println("in LiRaRestController post listproject method.");
		System.out.println("project Id is :..."+theProjectComments.getProj_id());
		System.out.println("employee Id is :..."+empId);
		theProjectComments.setProj_id(theProject.getProj_id());
		theProjectComments.setCreatedBy(empId);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		theProjectComments.setCreatedDate(formatter.format(calendar.getTime()));
		theProjectComments.setProj_comments_id(theProjectComments.getProj_comments_id());
		
		projectCommentsService.save(theProjectComments);
		ModelAndView mav = new ModelAndView();
		List<Project> projects = projectService.findAll();
		System.out.println("in findAll of listproject --- ");
		theModel.addAttribute("userName", principal.getName());
		System.out.println("empName  in listproject page----"+empName);
		// add to the spring model
		theModel.addAttribute("projects", projects);
		theModel.addAttribute("empName", empName);
		mav.setViewName("listProject");
		return mav;
    }
	
	@GetMapping("projectCreateForm")
	public ModelAndView newProject(Model model) {
		System.out.println("calling addProject page");
		Project project=new Project();
		model.addAttribute("project", project);
		ModelAndView mav = new ModelAndView();
		model.addAttribute("proj_todo_cnt", proj_todo_cnt);
		model.addAttribute("proj_inprogress_cnt", proj_inprogress_cnt);
		model.addAttribute("proj_archived_cnt", proj_archived_cnt);
		model.addAttribute("proj_cancelled_cnt", proj_cancelled_cnt);
	    mav.setViewName("createNewProject");
	    model.addAttribute("empName", empName);
	    return mav;
		
	}
	@PostMapping("showProjectCreateForm")
		public ModelAndView addProject1(@ModelAttribute("newProject") Project theProject,Model model) {
		    System.out.println("calling addProject page");
			
			model.addAttribute("project", theProject);
			HashMap<Integer,String> GrpLeaderList = empService.findByRole("groupleader");
			HashMap<Integer,String> CoordinatorList = empService.findByRole("coordinator");
			HashMap<Integer,String> QAList = empService.findByRole("QA");
			HashMap<Integer,String> QCList = empService.findByRole("QC");
		    
		    model.addAttribute("GrpLeaderList", GrpLeaderList);
		    model.addAttribute("CoordinatorList", CoordinatorList);
		    model.addAttribute("QAList", QAList);
		    model.addAttribute("QCList", QCList);
		    
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("createProject");
		    model.addAttribute("proj_todo_cnt", proj_todo_cnt);
			model.addAttribute("proj_inprogress_cnt", proj_inprogress_cnt);
			model.addAttribute("proj_archived_cnt", proj_archived_cnt);
			model.addAttribute("proj_cancelled_cnt", proj_cancelled_cnt);
		    model.addAttribute("empName", empName);
		    return mav;
	    }
	
	
	@PostMapping("/saveproject")
	public ModelAndView addProject(@ModelAttribute("newProject") Project theProject,Model model) {
		System.out.println(" adding project");
		System.out.println("saveproject-- theProject.getProjectId()---"+ theProject.getProj_id());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(theProject.getProj_id() > 0) {
			
		}else {
			System.out.println("saveProject-- int NOT NULL AUTO_INCREMENT,.getProjectId()---"+ theProject.getProj_id());
			theProject.setProj_id(theProject.getProj_id());
		}
		System.out.println("description in saveproject" +theProject.getDescription());
		
		System.out.println("proj_name saveproject" +theProject.getProj_name());
		System.out.println("project code in saveproject" +theProject.getProj_code());
		System.out.println("template in saveproject" +theProject.getProj_template());
		System.out.println("primary grp leader in saveproject" +theProject.getPrimary_grp_leader_id());
		System.out.println("hod bio id in saveproject" +theProject.getPrimary_hod_bio_id());
		
		theProject.setStatus("todo");
		theProject.setCreatedBy(empId);
		System.out.println("empid in saveproject method----"+empId);
		theProject.setCreatedDate(formatter.format(calendar.getTime()));
		theProject.setModifiedBy(empId);
		System.out.println("empid in saveproject method----"+empId);
		theProject.setModifiedDate(formatter.format(calendar.getTime()));
		proj_todo_cnt = proj_todo_cnt+1;
		model.addAttribute("proj_todo_cnt", proj_todo_cnt);
		model.addAttribute("proj_inprogress_cnt", proj_inprogress_cnt);
		model.addAttribute("proj_archived_cnt", proj_archived_cnt);
		model.addAttribute("proj_cancelled_cnt", proj_cancelled_cnt);
		projectService.save(theProject);
		Project newProject = new Project();
		model.addAttribute("newProject", newProject);
		List<Project> projects = projectService.findAll();
		model.addAttribute("projects", projects);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcome1");
		return mav;
	}
	
	
	@GetMapping("listProjectComments")
	public ModelAndView listProjectComments(@RequestParam("projectId") int theId, Model theModel ) {
		System.out.println("in LiRaRestController listProjectComments method.");
//		return empService.findAll();
		Project project = projectService.findById(theId);
		String projectName=project.getProj_name();
		
		ModelAndView mav = new ModelAndView();
		List<ProjectComments> projectComments = projectCommentsService.findByProjId(theId);
		System.out.println("in findAll of listProjectComments --- ");
		theModel.addAttribute("empName", empName);
		System.out.println("empName  in listProjectComments page----"+empName);
		// add to the spring model
		theModel.addAttribute("projectComments", projectComments);
		theModel.addAttribute("projectName", projectName);
		mav.setViewName("listProjectComments");
		return mav;
    }
	
	@GetMapping("showFormForProjectReport")
		public ModelAndView showFormForProjectReport(@RequestParam("projectId") int theId,@RequestParam("reporttype") int theReportType, Model model) {
	    System.out.println("calling showFormForProjectReport page");
		
		
	    ModelAndView mav = new ModelAndView();
	    model.addAttribute("empName", empName);
	    if(theReportType == 0 || theReportType == 1 )
	    {
	    	PyeReport thePyeReport = new PyeReport();
	    	thePyeReport.setProj_id(theId);
	    	model.addAttribute("PyeReport", thePyeReport);
	    	mav.setViewName("showFormForProjectReport");
	    }
	    else if(theReportType == 2)
	    {
	    	EMReport theEMReport = new EMReport();
	    	theEMReport.setProj_id(theId);
	    	model.addAttribute("EMReport", theEMReport);
	    	mav.setViewName("showFormForProjectReportEM");
	    }
	    else if(theReportType == 3)
	    {
	    	FMReport theFMReport = new FMReport();
	    	theFMReport.setProj_id(theId);
	    	model.addAttribute("FMReport", theFMReport);
	    	mav.setViewName("showFormForProjectReportFM");
	    }
	    else if(theReportType == 4)
	    {
	    	RecReport theRecReport = new RecReport();
	    	theRecReport.setProj_id(theId);
	    	model.addAttribute("RecReport", theRecReport);
	    	mav.setViewName("showFormForProjectReportREC");
	    }
	    else if(theReportType == 5)
	    {
	    	SelecReport theSelecReport = new SelecReport();
	    	theSelecReport.setProj_id(theId);
	    	model.addAttribute("SelecReport", theSelecReport);
	    	mav.setViewName("showFormForProjectReportSELEC");
	    }
	    return mav;
	
	
    }
	
	@PostMapping("generatereportpye")
	public RedirectView addReportPye(@ModelAttribute("PyeReport") PyeReport thePyeReport) {
		System.out.println(" generating pye report");
		System.out.println("generate report-- thePyeReport.getreportId()---"+ thePyeReport.getReport_id());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(thePyeReport.getReport_id()==0) {
			
		}else {
			System.out.println("generateReport-- int NOT NULL AUTO_INCREMENT,.getReportId()---"+ thePyeReport.getReport_id());
			thePyeReport.setReport_id(thePyeReport.getReport_id());
		}
		
		
		JSONArray pyeinputlist = new JSONArray();
		JSONObject pyeinputdetails = new JSONObject();
		pyeinputdetails.put("rawData", "tmp/sgsg.csv");
		pyeinputlist.add(pyeinputdetails);
		//pyeinputdetails.put("rawData", "tmp/sgsg12.csv");
		
		//pyeinputdetails.put("type", "Pye");
		pyeinputlist.add(pyeinputdetails);
		
		JSONObject pyeconfigdetails = new JSONObject();
	    pyeconfigdetails.put("projectID", thePyeReport.getProj_id());
	    pyeconfigdetails.put("type", thePyeReport.getReport_type());
	    pyeconfigdetails.put("Input", pyeinputlist);
	    pyeconfigdetails.put("analyze", thePyeReport.getAnalyte());
	    pyeconfigdetails.put("internalStd", thePyeReport.getInternal_std());
	    pyeconfigdetails.put("aquisitionId", thePyeReport.getAquisition_id());
	    pyeconfigdetails.put("slope", thePyeReport.getSlope());
	    pyeconfigdetails.put("intercept", thePyeReport.getIntercept());
	    pyeconfigdetails.put("regression", thePyeReport.getRegression());
	    pyeconfigdetails.put("stdComment", thePyeReport.getStd_comment());
	    pyeconfigdetails.put("qcComment", thePyeReport.getQccomment());
	    pyeconfigdetails.put("reviewedBy", thePyeReport.getStdreview_by());
	    pyeconfigdetails.put("qcReviewedBy", thePyeReport.getQcreview_by());
	    pyeconfigdetails.put("nSTDs", thePyeReport.getNoof_stds());
	    pyeconfigdetails.put("nConcentrations", thePyeReport.getN_concentrations());
	    
	    JSONObject pyeconfigObject = new JSONObject(); 
        pyeconfigObject.put("pyeconfig", pyeconfigdetails);
        JSONArray pyeconfiglist = new JSONArray();
        pyeconfiglist.add(pyeconfigObject);
	    
        JSONArray pyeOutputlist = new JSONArray();
        JSONObject pyeOutObject = new JSONObject();
        pyeOutObject.put("output", " parameter : /tmp/agag.json, image: /tmp/agag.jpg,  type: QC");
        pyeOutputlist.add(pyeOutObject);
        
        JSONObject pyeFinalConfig = new JSONObject();
        //pyeFinalConfig.put("pyeinputlist", pyeinputlist);
        pyeFinalConfig.put("pyeconfiglist", pyeconfiglist);
        pyeFinalConfig.put("pyeOutputlist", pyeOutputlist);
        
        try (FileWriter file = new FileWriter("config_PYE.json")) {
        	file.write(pyeFinalConfig.toJSONString());
//            file.write(pyeconfiglist.toJSONString());
//            file.write(pyeOutputlist.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
       
        thePyeReport.setProj_id(thePyeReport.getProj_id());
		System.out.println("thePyeReport in generateReport method----"+thePyeReport.getProj_id());
		thePyeReport.setModified_date(formatter.format(calendar.getTime()));
		thePyeReport.setModified_by(empId);
		System.out.println("thePyeReport in generateReport method----"+empId);
		thePyeReport.setModified_date(formatter.format(calendar.getTime()));
		
		pyeReportService.save(thePyeReport);
		return new RedirectView("/lira/listProject");
	}
	
	@PostMapping("generatereportem")
	public RedirectView addReportEm(@ModelAttribute("EMReport") EMReport theEMReport) {
		System.out.println(" generating pye report");
		System.out.println("generate report-- thePyeReport.getreportId()---"+ theEMReport.getReport_id());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(theEMReport.getReport_id()==0) {
			
		}else {
			System.out.println("generateReport-- int NOT NULL AUTO_INCREMENT,.getReportId()---"+ theEMReport.getReport_id());
			theEMReport.setReport_id(theEMReport.getReport_id());
		}
		
		JSONArray eminputlist = new JSONArray();
		JSONObject eminputdetails = new JSONObject();
		eminputdetails.put("input", "rawData : tmp/sgsg.csv");		
		eminputdetails.put("type", "EM");
		eminputlist.add(eminputdetails);
		
		
		JSONObject emconfigdetails = new JSONObject();
		    
		emconfigdetails.put("projectID", theEMReport.getProj_id());
		emconfigdetails.put("type", theEMReport.getReport_type());
		emconfigdetails.put("analyze", theEMReport.getAnalyte());
		emconfigdetails.put("internalStd", theEMReport.getInternal_std());
		emconfigdetails.put("aquisitionId", theEMReport.getAquisition_id());
		emconfigdetails.put("arComment", theEMReport.getArearatio_comment());
		emconfigdetails.put("ocComment", theEMReport.getQccomment());
		emconfigdetails.put("arReviewedBy", theEMReport.getArearatio_by());
		emconfigdetails.put("ocReviewedBy", theEMReport.getQcreview_by());
		emconfigdetails.put("nSamples", theEMReport.getNoof_samples());
		
		JSONObject emconfigObject = new JSONObject(); 
        emconfigObject.put("emconfig", emconfigdetails);
        JSONArray emconfiglist = new JSONArray();
        emconfiglist.add(emconfigObject);
        
        JSONArray emOutputlist = new JSONArray();
        JSONObject emOutObject = new JSONObject();
        emOutObject.put("output", " parameter : /tmp/agag.json, image: /tmp/agag.jpg,  type: QC");
        emOutputlist.add(emOutObject);
        
        try (FileWriter file = new FileWriter("config_EM.json")) {
        	file.write(eminputlist.toJSONString());
            file.write(emconfiglist.toJSONString());
            file.write(emOutputlist.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        theEMReport.setProj_id(theEMReport.getProj_id());
		System.out.println("theEMReport in generateReport method----"+empId);
		theEMReport.setModified_date(formatter.format(calendar.getTime()));
		theEMReport.setModified_by(empId);
		System.out.println("theEMReport in generateReport method----"+empId);
		theEMReport.setModified_date(formatter.format(calendar.getTime()));
		
		emReportService.save(theEMReport);
		return new RedirectView("/lira/listProject");
	}
	
	@PostMapping("generatereportfm")
	public RedirectView addReportFm(@ModelAttribute("FMReport") FMReport theFMReport) {
		System.out.println(" generating pye report");
		System.out.println("generate report-- thePyeReport.getreportId()---"+ theFMReport.getReport_id());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(theFMReport.getReport_id()==0) {
			
		}else {
			System.out.println("generateReport-- int NOT NULL AUTO_INCREMENT,.getReportId()---"+ theFMReport.getReport_id());
			theFMReport.setReport_id(theFMReport.getReport_id());
		}
		
		JSONArray fminputlist = new JSONArray();
		JSONObject fminputdetails = new JSONObject();
		fminputdetails.put("input", "rawData : tmp/sgsg.csv");		
		fminputdetails.put("type", "FM");
		fminputlist.add(fminputdetails);
		
		JSONObject fmconfigdetails = new JSONObject();
		    
		fmconfigdetails.put("projectID", theFMReport.getProj_id());
		fmconfigdetails.put("type", theFMReport.getReport_type());
		fmconfigdetails.put("analyze", theFMReport.getAnalyte());
		fmconfigdetails.put("internalStd", theFMReport.getInternal_std());
		fmconfigdetails.put("aquisitionId", theFMReport.getAquisition_id());
		fmconfigdetails.put("PCAComment", theFMReport.getPca_comment());
		fmconfigdetails.put("PCBComment", theFMReport.getPcb_comment());
		fmconfigdetails.put("PCAReviewedBy", theFMReport.getPcareview_by());
		fmconfigdetails.put("PCBReviewedBy", theFMReport.getPcbreview_by());
		fmconfigdetails.put("nSamples", theFMReport.getNoof_samples());
		
		JSONObject fmconfigObject = new JSONObject(); 
        fmconfigObject.put("fmconfig", fmconfigdetails);
        JSONArray fmconfiglist = new JSONArray();
        fmconfiglist.add(fmconfigObject);
        
        JSONArray fmOutputlist = new JSONArray();
        JSONObject fmOutObject = new JSONObject();
        fmOutObject.put("output", " parameter : /tmp/agag.json, image: /tmp/agag.jpg,  type: QC");
        fmOutputlist.add(fmOutObject);
        try (FileWriter file = new FileWriter("config_FM.json")) {
        	 
            file.write(fminputlist.toJSONString());
            file.write(fmconfiglist.toJSONString());
            file.write(fmOutputlist.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        theFMReport.setProj_id(theFMReport.getProj_id());
		System.out.println("theEMReport in generateReport method----"+empId);
		theFMReport.setModified_date(formatter.format(calendar.getTime()));
		theFMReport.setModified_by(empId);
		System.out.println("theEMReport in generateReport method----"+empId);
		theFMReport.setModified_date(formatter.format(calendar.getTime()));
		
		fmReportService.save(theFMReport);
		return new RedirectView("/lira/listProject");
	}
	
	@PostMapping("generatereportrec")
	public RedirectView addReportRec(@ModelAttribute("RecReport") RecReport theRecReport) {
		System.out.println(" generating pye report");
		System.out.println("generate report rec-- theRecReport.getreportId()---"+ theRecReport.getReport_id());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(theRecReport.getReport_id()==0) {
			
		}else {
			System.out.println("generateReport rec-- int NOT NULL AUTO_INCREMENT,.getReportId()---"+ theRecReport.getReport_id());
			theRecReport.setReport_id(theRecReport.getReport_id());
		}
		
		JSONArray recinputlist = new JSONArray();
		JSONObject recinputdetails = new JSONObject();
		recinputdetails.put("input", "rawData : tmp/sgsg.csv");		
		recinputdetails.put("type", "REC");
		recinputlist.add(recinputdetails);
		
		
		JSONObject recconfigdetails = new JSONObject();
	    
		recconfigdetails.put("projectID", theRecReport.getProj_id());
		recconfigdetails.put("type", theRecReport.getReport_type());
		recconfigdetails.put("analyze", theRecReport.getAnalyte());
		recconfigdetails.put("aquisitionId", theRecReport.getAquisition_id());
		recconfigdetails.put("araComment", theRecReport.getAra_comment());
		recconfigdetails.put("arisComment", theRecReport.getAris_comment());
		recconfigdetails.put("rraComment", theRecReport.getRra_comment());
		recconfigdetails.put("rrisComment", theRecReport.getRris_comment());
		recconfigdetails.put("araReviewedBy", theRecReport.getArareview_by());
		recconfigdetails.put("arisReviewedBy", theRecReport.getArisreview_by());
		recconfigdetails.put("rraReviewedBy", theRecReport.getRrareview_by());
		recconfigdetails.put("rrisReviewedBy", theRecReport.getRrisreview_by());
		JSONObject recconfigObject = new JSONObject(); 
        recconfigObject.put("recconfig", recconfigdetails);
        JSONArray recconfiglist = new JSONArray();
        recconfiglist.add(recconfigObject);
		
        JSONArray recOutputlist = new JSONArray();
        JSONObject recOutObject = new JSONObject();
        recOutObject.put("parameter", " /tmp/agag.json, image: /tmp/agag.jpg,  type: ARA");
        recOutObject.put("parameter", " /tmp/agag.json, image: /tmp/agag.jpg,  type: ARIS");
        recOutObject.put("parameter", " /tmp/agag.json, image: /tmp/agag.jpg,  type: RRA");
        recOutObject.put("parameter", " /tmp/agag.json, image: /tmp/agag.jpg,  type: RRIS");
        recOutputlist.add(recOutObject);
		

        
        try (FileWriter file = new FileWriter("config_REC.json")) {
        	 
            file.write(recinputlist.toJSONString());
            file.write(recconfiglist.toJSONString());
            file.write(recOutputlist.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        theRecReport.setProj_id(theRecReport.getProj_id());
		System.out.println("theRECReport in generateReport method----"+empId);
		theRecReport.setModified_date(formatter.format(calendar.getTime()));
		theRecReport.setModified_by(empId);
		System.out.println("theRECReport in generateReport method----"+empId);
		theRecReport.setModified_date(formatter.format(calendar.getTime()));
		
		recReportService.save(theRecReport);
		return new RedirectView("/lira/listProject");
	}
	
	@PostMapping("generatereportselec")
	public RedirectView addReportSelec(@ModelAttribute("SelecReport") SelecReport theSelecReport) {
		System.out.println(" generating selec report");
		System.out.println("generate report rec-- theRecReport.getreportId()---"+ theSelecReport.getReport_id());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(theSelecReport.getReport_id()==0) {
			
		}else {
			System.out.println("generateReport rec-- int NOT NULL AUTO_INCREMENT,.getReportId()---"+ theSelecReport.getReport_id());
			theSelecReport.setReport_id(theSelecReport.getReport_id());
		}
		
		JSONArray selecinputlist = new JSONArray();
		JSONObject selecinputdetails = new JSONObject();
		selecinputdetails.put("input", "rawData : tmp/sgsg.csv");		
		selecinputdetails.put("type", "SELEC");
		selecinputlist.add(selecinputdetails);
		
		
		JSONObject selecconfigdetails = new JSONObject();
		selecconfigdetails.put("projectID", theSelecReport.getProj_id());
		selecconfigdetails.put("type", theSelecReport.getReport_type());
		selecconfigdetails.put("analyze", theSelecReport.getAnalyte());
		selecconfigdetails.put("aquisitionId", theSelecReport.getAquisition_id());
		selecconfigdetails.put("comment", theSelecReport.getComment());
		selecconfigdetails.put("reviewedBy", theSelecReport.getReview_by());
		
	
		JSONObject selecconfigObject = new JSONObject(); 
		selecconfigObject.put("selecconfig", selecconfigdetails);
		JSONArray selecconfiglist = new JSONArray();
        selecconfiglist.add(selecconfigObject);
        
                
        JSONArray selecOutputlist = new JSONArray();
        JSONObject selecOutObject = new JSONObject();
        selecOutObject.put("output", " parameter : /tmp/agag.json, image: /tmp/agag.jpg,  type: SELEC");
        selecOutputlist.add(selecOutObject);
        try (FileWriter file = new FileWriter("config_SELEC.json")) {
        	 
            file.write(selecinputlist.toJSONString());
            file.write(selecconfiglist.toJSONString());
            file.write(selecOutputlist.toJSONString());
            
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        theSelecReport.setProj_id(theSelecReport.getProj_id());
		System.out.println("theSelecReport in generateReport method----"+empId);
		theSelecReport.setModified_date(formatter.format(calendar.getTime()));
		theSelecReport.setModified_by(empId);
		System.out.println("theSelecReport in generateReport method----"+empId);
		theSelecReport.setModified_date(formatter.format(calendar.getTime()));
		
		selecReportService.save(theSelecReport);
		return new RedirectView("/lira/listProject");
	}
	
/*	@GetMapping("projectDetails")
	public ModelAndView projectDetails(@RequestParam("projectId") String theId, Model theModel ) {
		System.out.println("in LiRaRestController projectDetails method.");
		ModelAndView mav = new ModelAndView();
		
		Project project = projectService.findById(theId);
		theModel.addAttribute("project", project);
		mav.setViewName("projectDetails");
		return mav;
		
	}*/
	
	@GetMapping("projectDetails")
	public ModelAndView projectDetails(@RequestParam("projectId") int theId, Model theModel ) {
		System.out.println("in LiRaRestController projectDetails method.");
		ModelAndView mav = new ModelAndView();
		List<ProjectComments> proj_cmnts_list = projectCommentsService.findByProjId(theId);
		String procmts = "";
		if(proj_cmnts_list != null)
		{
			System.out.println("in LiRaRestController projectDetails method -proj_cmnts_list is not null-");
			for(ProjectComments pc : proj_cmnts_list)
			{
				 procmts = procmts.concat(pc.getProjectComments());
				 procmts = procmts.concat("\n");
			}
		}
		ProjectComments proj_comments = new ProjectComments();
		proj_comments.setProj_id(theId);
		//proj_comments.setProjectComments("");
		proj_comments.setCreatedBy(empId);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		proj_comments.setCreatedDate(formatter.format(calendar.getTime()));
		proj_comments.setProj_comments_id(proj_comments.getProj_comments_id());		
		theModel.addAttribute("proj_cmnts_list",procmts);
		
		Project project = projectService.findById(theId);
		theModel.addAttribute("project", project);
		theModel.addAttribute("proj_comments", proj_comments);
		theModel.addAttribute("empName", empName);
		mav.setViewName("projectDetails");
		return mav;
		
	}
	
	
	private String projId=null;
	@GetMapping("/showFormForProjectDocUpload")
	public ModelAndView showFormForProjectDocUpload( Model theModel,@RequestParam("projectId") String theProjId ) {
		System.out.println("in showFormForProjectDocUpload--"+theProjId);
		projId = theProjId;
		//theModel.addAttribute("ProjId", theProjId);
		theModel.addAttribute("empName", empName);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("uploadDocument");
	    return mav;
		
	}
	
	private Path fileStorageLocation=null;
	@PostMapping("/upload")
    public RedirectView uploadFile(@RequestParam("rawDataFile") MultipartFile rawDataFile,@RequestParam("proj_id") String theProjId ,
    		@ModelAttribute("experiment") Experiment theExperiment,@ModelAttribute("pyereport") PyeReport thePyeReport,Model theModel, RedirectAttributes attributes) {
		// save Experiment
		
		theExperiment.setProj_id(Integer.parseInt(theProjId));
		if(theExperiment.getExperiment_id() > 0)
		{
			
		}
		else
		{
			theExperiment.setExperiment_id(theExperiment.getExperiment_id());
			
		}
		System.out.println("uploadFile---rawDataFile----  "+rawDataFile);
		System.out.println("uploadFile---rawDataFile.getOriginalFilename()----  "+rawDataFile.getOriginalFilename());
		theExperiment.setRawdata_file(rawDataFile.getOriginalFilename());
		experimentService.save(theExperiment);
		
		
		
		Path targetLocation = uploadfile(rawDataFile,theProjId,attributes,theExperiment.getExperiment_id());
		
			generatePye(thePyeReport,theProjId,targetLocation);
		
    		return new RedirectView("/lira/experimentsHome");
      
		
    }
	
	public void generatePye(PyeReport thePyeReport,String ProjId,Path inputfilename)
	{
		System.out.println(" generating pye report");
		System.out.println(" generating pye report--- inputfilename ---  "+inputfilename);
		System.out.println("generate report-- thePyeReport.getreportId()---"+ ProjId);
		int theProjId = Integer.parseInt(ProjId);
		if(thePyeReport.getReport_id()==0) {
			
		}else {
			System.out.println("generateReport-- int NOT NULL AUTO_INCREMENT,.getReportId()---"+ thePyeReport.getReport_id());
			thePyeReport.setReport_id(thePyeReport.getReport_id());
		}
		
		 
	      
		
		JSONArray pyeinputlist = new JSONArray();
		JSONObject pyeInputConfigDetails = new JSONObject();
		pyeInputConfigDetails.put("rawData", inputfilename);
		pyeinputlist.add(pyeInputConfigDetails);
		
		JSONArray pyeOutputList = new JSONArray();
		JSONObject pyeOutputConfigDetails = new JSONObject();
		pyeOutputConfigDetails.put("type", "CC");
		pyeOutputConfigDetails.put("image", "CC.jpg");
		pyeOutputConfigDetails.put("parameters", "CC.json");
		pyeOutputList.add(pyeOutputConfigDetails);
		
		pyeOutputConfigDetails.put("type", "QC");
		pyeOutputConfigDetails.put("image", "QC.jpg");
		pyeOutputConfigDetails.put("parameters", "QC.json");
		pyeOutputList.add(pyeOutputConfigDetails);
		
		
		JSONObject pyeconfigdetails = new JSONObject();
	    pyeconfigdetails.put("projectID", thePyeReport.getProj_id());
	    pyeconfigdetails.put("experimentID", thePyeReport.getExperiment_id());
	    
	    pyeconfigdetails.put("type", "PYE");
	    pyeconfigdetails.put("Input", pyeinputlist);
	    pyeconfigdetails.put("analyze", thePyeReport.getAnalyte());
	    pyeconfigdetails.put("internalStd", thePyeReport.getInternal_std());
	    pyeconfigdetails.put("aquisitionId", thePyeReport.getAquisition_id());
	    pyeconfigdetails.put("slope", thePyeReport.getSlope());
	    pyeconfigdetails.put("intercept", thePyeReport.getIntercept());
	    pyeconfigdetails.put("regression", thePyeReport.getRegression());
	    pyeconfigdetails.put("stdComment", thePyeReport.getStd_comment());
	    pyeconfigdetails.put("qcComment", thePyeReport.getQccomment());
	   // pyeconfigdetails.put("reviewedBy", thePyeReport.getStdreview_by());
	  //  pyeconfigdetails.put("qcReviewedBy", thePyeReport.getQcreview_by());
	    pyeconfigdetails.put("nSTDs", thePyeReport.getNoof_stds());
	    pyeconfigdetails.put("nConcentrations", thePyeReport.getN_concentrations());
	    
	    pyeconfigdetails.put("output", pyeOutputList);
	    
        
        try (FileWriter file = new FileWriter("config_PYE.json")) {
        	file.write(pyeconfigdetails.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
       
        thePyeReport.setProj_id(theProjId);
		System.out.println("thePyeReport in generateReport method----"+empId);
		thePyeReport.setModified_date(formatter.format(calendar.getTime()));
		thePyeReport.setModified_by(empId);
		System.out.println("thePyeReport in generateReport method----"+empId);
		thePyeReport.setModified_date(formatter.format(calendar.getTime()));
		
		pyeReportService.save(thePyeReport);
	}
	
	public Path uploadfile(MultipartFile rawDataFile,String theProjId,RedirectAttributes attributes,int expId)
	{
	
		String uploadDir = configProp.getConfigValue("file.uploadDir"); 
		
		System.out.println(" uploading document metadata to db" +theProjId +"uploadDir --- "+uploadDir);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		this.fileStorageLocation = (Path) Paths.get(uploadDir+"\\"+theProjId)
				.toAbsolutePath().normalize();
				 try {
				   Files.createDirectories(this.fileStorageLocation);
				} catch (Exception ex) {
				   System.out.println("Could not create the directory where the uploaded files will be stored.");
					//throw new DocumentStorageException("Could not create the directory where the uploaded files will be stored.", ex);
			    }
        // check if file is empty
        if (rawDataFile.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            new RedirectView("/lira/experimentsHome");
        }

        // normalize the file path
        String fileName = StringUtils.cleanPath(rawDataFile.getOriginalFilename());
        System.out.println("fileName--"+rawDataFile.getName()+" "+fileName+" "+theProjId);
        InputFile doc = new InputFile();
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        // save the file on the local file system
        try {
        	
            //Files.copy(file.getInputStream(), targetLocation, StandardCopyOption..REPLACE_EXISTING);
            byte[] bytes=rawDataFile.getBytes();
            int projId = Integer.parseInt(theProjId);
            List<InputFile> inputFileList=inputFileStorageService.findByProjId(projId);
            int count=0;
            for (InputFile temp : inputFileList) {
                
				System.out.println(temp);
                if(( temp.getFileName()).equalsIgnoreCase(fileName)){
                	count++;
                	int at = fileName.indexOf('.');
                	System.out.println("fileName.substring(0, at)---"+fileName.substring(0, at));
                	System.out.println("fileName.substring(at)---"+fileName.substring(at));
                    if(count==1) {
                	fileName=fileName.substring(0, at) + count + fileName.substring(at);
                    }else if(count<10) {
                    	fileName=fileName.substring(0, at-1) + count + fileName.substring(at);
                    }else if(count>10) {
                    	fileName=fileName.substring(0, at-2) + count + fileName.substring(at);
                    }
                	
                }
                
            	//fileName=splitName[1]+count+"."+splitName[2];
            }
            
            System.out.println("count---"+count);
            targetLocation = this.fileStorageLocation.resolve(fileName);
            System.out.println("targetLocation----   "+targetLocation);
            Files.write(targetLocation, bytes);
            System.out.println("file size--"+bytes);
            System.out.println("docType----"+ rawDataFile.getContentType());
            doc.setFileName(fileName);
            doc.setDocumentType(rawDataFile.getContentType());
            doc.setUploadDir(targetLocation.toString());
            doc.setProjId(projId);
            doc.setExperiment_id(expId);
            doc.setCreatedBy(empId);
    		System.out.println("empid in upload method----"+empId);
    		doc.setCreatedDate(formatter.format(calendar.getTime()));
            
            inputFileStorageService.storeFile(doc);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
        	 attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        }
        return targetLocation;
	}
	
	/*@PostMapping("/upload/db")
	public ResponseEntity uploadToDB(@RequestParam("file") MultipartFile file) {
		Document doc = new Document();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		doc.setDocName(fileName);
		try {
			doc.setFile(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		documentDao.save(doc);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/files/download/")
				.path(fileName).path("/db")
				.toUriString();
		return ResponseEntity.ok(fileDownloadUri);
	}*/
	
}

