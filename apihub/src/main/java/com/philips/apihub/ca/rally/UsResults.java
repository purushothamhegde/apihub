package com.philips.apihub.ca.rally;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsResults

{
 
	@JsonProperty("_rallyAPIMajor")
	   private String _rallyAPIMajor;
	@JsonProperty("_rallyAPIMinor")
	    private String _rallyAPIMinor;
	@JsonProperty("_ref")
	    private String _ref;
	@JsonProperty("_refObjectUUID")
	    private String _refObjectUUID;
	@JsonProperty("_objectVersion")
	    private String _objectVersion;
	@JsonProperty("_refObjectName")
	    private String _refObjectName;
	@JsonProperty("CreationDate")
	    private String CreationDate;
	@JsonProperty("_CreatedAt")
	    private String _CreatedAt;
	@JsonProperty("ObjectID")
	    private String ObjectID;
	@JsonProperty("ObjectUUID")
	    private String ObjectUUID;
	@JsonProperty("VersionId")
	    private String VersionId;
	@JsonProperty("Subscription")
	    private Subscription Subscription;
	@JsonProperty("Workspace")
	    private Workspace Workspace;
	@JsonProperty("Changesets")
	    private Changesets Changesets;
	@JsonProperty("Connections")
	    private Connections Connections;
	@JsonProperty("CreatedBy")
	    private CreatedBy CreatedBy;
	@JsonProperty("Description")
	    private String Description;
	@JsonProperty("Discussion")
	    private Discussion Discussion;
	@JsonProperty("DisplayColor")
	    private String DisplayColor;
	@JsonProperty("Expedite")
	    private boolean Expedite;
	@JsonProperty("FormattedID")
	    private String FormattedID;
	@JsonProperty("LastUpdateDate")
	    private String LastUpdateDate;
	@JsonProperty("LatestDiscussionAgeInMinutes")
	    private String LatestDiscussionAgeInMinutes;
	@JsonProperty("Milestones")
	    private Milestones Milestones;
	@JsonProperty("Name")
	    private String Name;
	@JsonProperty("Notes")
	    private String Notes;
	@JsonProperty("Owner")
	    private Owner Owner;
	@JsonProperty("Project")
	    private Project Project;
	@JsonProperty("Ready")
	    private boolean Ready;
	@JsonProperty("RevisionHistory")
	    private RevisionHistory RevisionHistory;
	@JsonProperty("Tags")
	    private Tags Tags;
	@JsonProperty("FlowState")
	    private FlowState FlowState;
	@JsonProperty("FlowStateChangedDate")
	    private String FlowStateChangedDate;
	@JsonProperty("LastBuild")
	    private String LastBuild;
	@JsonProperty("LastRun")
	    private String LastRun;
	@JsonProperty("PassingTestCaseCount")
	    private int PassingTestCaseCount;
	@JsonProperty("ScheduleState")
	    private String ScheduleState;
	@JsonProperty("ScheduleStatePrefix")
	    private String ScheduleStatePrefix;
	@JsonProperty("TestCaseCount")
	    private int TestCaseCount;
	@JsonProperty("Attachments")
	    private Attachments Attachments;
	@JsonProperty("Package")
	    private String Package;
	@JsonProperty("AcceptedDate")
	    private String AcceptedDate;
	@JsonProperty("Blocked")
	    private boolean Blocked;
	@JsonProperty("BlockedReason")
	    private String BlockedReason;
	@JsonProperty("Blocker")
	    private String Blocker;
	@JsonProperty("Children")
	    private Children Children;
	@JsonProperty("DefectStatus")
	    private String DefectStatus;
	@JsonProperty("Defects")
	    private Defects Defects;
	@JsonProperty("DirectChildrenCount")
	    private int DirectChildrenCount;
	@JsonProperty("DragAndDropRank")
	    private String DragAndDropRank;
	@JsonProperty("HasParent")
	    private boolean HasParent;
	@JsonProperty("InProgressDate")
	    private String InProgressDate;
	@JsonProperty("Iteration")
	    private Iteration Iteration;
	@JsonProperty("Parent")
	    private String Parent;
	@JsonProperty("PlanEstimate")
	    private int PlanEstimate;
	@JsonProperty("Predecessors")
	    private Predecessors Predecessors;
	@JsonProperty("Recycled")
	    private boolean Recycled;
	@JsonProperty("Release")
	    private Release Release;
	@JsonProperty("Successors")
	    private Successors Successors;
	@JsonProperty("TaskActualTotal")
	    private int TaskActualTotal;
	@JsonProperty("TaskEstimateTotal")
	    private int TaskEstimateTotal;
	@JsonProperty("TaskRemainingTotal")
	    private int TaskRemainingTotal;
	@JsonProperty("TaskStatus")
	    private String TaskStatus;
	@JsonProperty("Tasks")
	    private Tasks Tasks;
	@JsonProperty("TestCaseStatus")
	    private String TestCaseStatus;
	@JsonProperty("TestCases")
	    private TestCases TestCases;
	@JsonProperty("c_AcceptanceCriteria")
	    private String c_AcceptanceCriteria;
	@JsonProperty("c_AcceptanceCriteriaFilled")
	    private boolean c_AcceptanceCriteriaFilled;
	@JsonProperty("c_AgileMaturityMeasurement05")
	    private String c_AgileMaturityMeasurement05;
	@JsonProperty("c_BacklogQuality")
	    private String c_BacklogQuality;
	@JsonProperty("c_BusinessValue")
	    private String c_BusinessValue;
	@JsonProperty("c_Deliverysatisfactionscore110")
	    private String c_Deliverysatisfactionscore110;
	@JsonProperty("c_Drivers")
	    private String c_Drivers;
	@JsonProperty("c_DueDate")
	    private String c_DueDate;
	@JsonProperty("c_Excludefromcalculations")
	    private boolean c_Excludefromcalculations;
	@JsonProperty("Feature")
	    private Feature Feature;
	@JsonProperty("c_FunctionalCategory")
	    private String c_FunctionalCategory;
	@JsonProperty("c_IdeaURL")
	    private C_IdeaURL c_IdeaURL;
	@JsonProperty("c_KTToDS")
	    private boolean c_KTToDS;
	@JsonProperty("c_KTToOperation")
	    private boolean c_KTToOperation;
	@JsonProperty("c_LPTest")
	    private String c_LPTest;
	@JsonProperty("c_LPCVelocity")
	    private String c_LPCVelocity;
	@JsonProperty("c_Managementinformationrequest")
	    private String c_Managementinformationrequest;
	@JsonProperty("c_MoSCoWPriority")
	    private String c_MoSCoWPriority;
	@JsonProperty("c_OldHealthCareWorkspace")
	    private String c_OldHealthCareWorkspace;
	@JsonProperty("PortfolioItem")
	    private PortfolioItem PortfolioItem;
	@JsonProperty("c_ProductOwnerInvolvement15")
	    private String c_ProductOwnerInvolvement15;
	@JsonProperty("c_ProductOwners")
	    private String c_ProductOwners;
	@JsonProperty("c_ProgressStage")
	    private String c_ProgressStage;
	@JsonProperty("c_RCB")
	    private String c_RCB;
	@JsonProperty("c_ReadyKanbanState")
	    private String c_ReadyKanbanState;
	@JsonProperty("c_RegressionTest")
	    private String c_RegressionTest;
	@JsonProperty("c_ReleaseComments")
	    private String c_ReleaseComments;
	@JsonProperty("c_Retrospectiveactions")
	    private String c_Retrospectiveactions;
	@JsonProperty("c_Retrospectivenotes")
	    private String c_Retrospectivenotes;
	@JsonProperty("c_RiskDateIdentified")
	    private String c_RiskDateIdentified;
	@JsonProperty("c_RiskImpact")
	    private String c_RiskImpact;
	@JsonProperty("c_RiskPeriodpossibleoccurrence")
	    private String c_RiskPeriodpossibleoccurrence;
	@JsonProperty("c_RiskProbability")
	    private String c_RiskProbability;
	@JsonProperty("c_RiskResponsestrategy")
	    private String c_RiskResponsestrategy;
	@JsonProperty("c_RiskResponsestrategydescription")
	    private String c_RiskResponsestrategydescription;
	@JsonProperty("c_RiskSymtomsTriggers")
	    private String c_RiskSymtomsTriggers;
	@JsonProperty("c_ScopetopicID")
	    private String c_ScopetopicID;
	@JsonProperty("c_SIT")
	    private String c_SIT;
	@JsonProperty("c_SM7ChangeID")
	    private String c_SM7ChangeID;
	@JsonProperty("c_SpecificationDSID")
	    private String c_SpecificationDSID;
	@JsonProperty("c_SpecificationFRSID")
	    private String c_SpecificationFRSID;
	@JsonProperty("c_SpecificationURSID")
	    private String c_SpecificationURSID;
	@JsonProperty("c_TeamLifecycle")
	    private String c_TeamLifecycle;
	@JsonProperty("c_TeamSize")
	    private String c_TeamSize;
	@JsonProperty("c_Teamstatus")
	    private String c_Teamstatus;
	@JsonProperty("c_TestCoordinator")
	    private String c_TestCoordinator;
	@JsonProperty("c_USStatus")
	    private String c_USStatus;
	@JsonProperty("c_UserSponsor")
	    private String c_UserSponsor;
	@JsonProperty("c_VelocityBaselineOverwrite")
	    private String c_VelocityBaselineOverwrite;
	@JsonProperty("c_zzobsoleteboolean1")
	    private boolean c_zzobsoleteboolean1;
	@JsonProperty("c_zzobsoleteRiskSymtomsTriggers")
	    private String c_zzobsoleteRiskSymtomsTriggers;
	@JsonProperty("c_zzobsoletestring1")
	    private String c_zzobsoletestring1;
	@JsonProperty("_type")
	    private String _type;

	
	
	public void set_rallyAPIMajor(String _rallyAPIMajor){
        this._rallyAPIMajor = _rallyAPIMajor;
    }
    public String get_rallyAPIMajor(){
        return this._rallyAPIMajor;
    }
    public void set_rallyAPIMinor(String _rallyAPIMinor){
        this._rallyAPIMinor = _rallyAPIMinor;
    }
    public String get_rallyAPIMinor(){
        return this._rallyAPIMinor;
    }
    public void set_ref(String _ref){
        this._ref = _ref;
    }
    public String get_ref(){
        return this._ref;
    }
    public void set_refObjectUUID(String _refObjectUUID){
        this._refObjectUUID = _refObjectUUID;
    }
    public String get_refObjectUUID(){
        return this._refObjectUUID;
    }
    public void set_objectVersion(String _objectVersion){
        this._objectVersion = _objectVersion;
    }
    public String get_objectVersion(){
        return this._objectVersion;
    }
    public void set_refObjectName(String _refObjectName){
        this._refObjectName = _refObjectName;
    }
    public String get_refObjectName(){
        return this._refObjectName;
    }
    public void setCreationDate(String CreationDate){
        this.CreationDate = CreationDate;
    }
    public String getCreationDate(){
        return this.CreationDate;
    }
    public void set_CreatedAt(String _CreatedAt){
        this._CreatedAt = _CreatedAt;
    }
    public String get_CreatedAt(){
        return this._CreatedAt;
    }
    public void setObjectID(String ObjectID){
        this.ObjectID = ObjectID;
    }
    public String getObjectID(){
        return this.ObjectID;
    }
    public void setObjectUUID(String ObjectUUID){
        this.ObjectUUID = ObjectUUID;
    }
    public String getObjectUUID(){
        return this.ObjectUUID;
    }
    public void setVersionId(String VersionId){
        this.VersionId = VersionId;
    }
    public String getVersionId(){
        return this.VersionId;
    }
    public void setSubscription(Subscription Subscription){
        this.Subscription = Subscription;
    }
    public Subscription getSubscription(){
        return this.Subscription;
    }
    public void setWorkspace(Workspace Workspace){
        this.Workspace = Workspace;
    }
    public Workspace getWorkspace(){
        return this.Workspace;
    }
    public void setChangesets(Changesets Changesets){
        this.Changesets = Changesets;
    }
    public Changesets getChangesets(){
        return this.Changesets;
    }
    public void setConnections(Connections Connections){
        this.Connections = Connections;
    }
    public Connections getConnections(){
        return this.Connections;
    }
    public void setCreatedBy(CreatedBy CreatedBy){
        this.CreatedBy = CreatedBy;
    }
    public CreatedBy getCreatedBy(){
        return this.CreatedBy;
    }
    public void setDescription(String Description){
        this.Description = Description;
    }
    public String getDescription(){
        return this.Description;
    }
    public void setDiscussion(Discussion Discussion){
        this.Discussion = Discussion;
    }
    public Discussion getDiscussion(){
        return this.Discussion;
    }
    public void setDisplayColor(String DisplayColor){
        this.DisplayColor = DisplayColor;
    }
    public String getDisplayColor(){
        return this.DisplayColor;
    }
    public void setExpedite(boolean Expedite){
        this.Expedite = Expedite;
    }
    public boolean getExpedite(){
        return this.Expedite;
    }
    public void setFormattedID(String FormattedID){
        this.FormattedID = FormattedID;
    }
    public String getFormattedID(){
        return this.FormattedID;
    }
    public void setLastUpdateDate(String LastUpdateDate){
        this.LastUpdateDate = LastUpdateDate;
    }
    public String getLastUpdateDate(){
        return this.LastUpdateDate;
    }
    public void setLatestDiscussionAgeInMinutes(String LatestDiscussionAgeInMinutes){
        this.LatestDiscussionAgeInMinutes = LatestDiscussionAgeInMinutes;
    }
    public String getLatestDiscussionAgeInMinutes(){
        return this.LatestDiscussionAgeInMinutes;
    }
    public void setMilestones(Milestones Milestones){
        this.Milestones = Milestones;
    }
    public Milestones getMilestones(){
        return this.Milestones;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return this.Name;
    }
    public void setNotes(String Notes){
        this.Notes = Notes;
    }
    public String getNotes(){
        return this.Notes;
    }
    public void setOwner(Owner Owner){
        this.Owner = Owner;
    }
    public Owner getOwner(){
        return this.Owner;
    }
    public void setProject(Project Project){
        this.Project = Project;
    }
    public Project getProject(){
        return this.Project;
    }
    public void setReady(boolean Ready){
        this.Ready = Ready;
    }
    public boolean getReady(){
        return this.Ready;
    }
    public void setRevisionHistory(RevisionHistory RevisionHistory){
        this.RevisionHistory = RevisionHistory;
    }
    public RevisionHistory getRevisionHistory(){
        return this.RevisionHistory;
    }
    public void setTags(Tags Tags){
        this.Tags = Tags;
    }
    public Tags getTags(){
        return this.Tags;
    }
    public void setFlowState(FlowState FlowState){
        this.FlowState = FlowState;
    }
    public FlowState getFlowState(){
        return this.FlowState;
    }
    public void setFlowStateChangedDate(String FlowStateChangedDate){
        this.FlowStateChangedDate = FlowStateChangedDate;
    }
    public String getFlowStateChangedDate(){
        return this.FlowStateChangedDate;
    }
    public void setLastBuild(String LastBuild){
        this.LastBuild = LastBuild;
    }
    public String getLastBuild(){
        return this.LastBuild;
    }
    public void setLastRun(String LastRun){
        this.LastRun = LastRun;
    }
    public String getLastRun(){
        return this.LastRun;
    }
    public void setPassingTestCaseCount(int PassingTestCaseCount){
        this.PassingTestCaseCount = PassingTestCaseCount;
    }
    public int getPassingTestCaseCount(){
        return this.PassingTestCaseCount;
    }
    public void setScheduleState(String ScheduleState){
        this.ScheduleState = ScheduleState;
    }
    public String getScheduleState(){
        return this.ScheduleState;
    }
    public void setScheduleStatePrefix(String ScheduleStatePrefix){
        this.ScheduleStatePrefix = ScheduleStatePrefix;
    }
    public String getScheduleStatePrefix(){
        return this.ScheduleStatePrefix;
    }
    public void setTestCaseCount(int TestCaseCount){
        this.TestCaseCount = TestCaseCount;
    }
    public int getTestCaseCount(){
        return this.TestCaseCount;
    }
    public void setAttachments(Attachments Attachments){
        this.Attachments = Attachments;
    }
    public Attachments getAttachments(){
        return this.Attachments;
    }
    public void setPackage(String Package){
        this.Package = Package;
    }
    public String getPackage(){
        return this.Package;
    }
    public void setAcceptedDate(String AcceptedDate){
        this.AcceptedDate = AcceptedDate;
    }
    public String getAcceptedDate(){
        return this.AcceptedDate;
    }
    public void setBlocked(boolean Blocked){
        this.Blocked = Blocked;
    }
    public boolean getBlocked(){
        return this.Blocked;
    }
    public void setBlockedReason(String BlockedReason){
        this.BlockedReason = BlockedReason;
    }
    public String getBlockedReason(){
        return this.BlockedReason;
    }
    public void setBlocker(String Blocker){
        this.Blocker = Blocker;
    }
    public String getBlocker(){
        return this.Blocker;
    }
    public void setChildren(Children Children){
        this.Children = Children;
    }
    public Children getChildren(){
        return this.Children;
    }
    public void setDefectStatus(String DefectStatus){
        this.DefectStatus = DefectStatus;
    }
    public String getDefectStatus(){
        return this.DefectStatus;
    }
    public void setDefects(Defects Defects){
        this.Defects = Defects;
    }
    public Defects getDefects(){
        return this.Defects;
    }
    public void setDirectChildrenCount(int DirectChildrenCount){
        this.DirectChildrenCount = DirectChildrenCount;
    }
    public int getDirectChildrenCount(){
        return this.DirectChildrenCount;
    }
    public void setDragAndDropRank(String DragAndDropRank){
        this.DragAndDropRank = DragAndDropRank;
    }
    public String getDragAndDropRank(){
        return this.DragAndDropRank;
    }
    public void setHasParent(boolean HasParent){
        this.HasParent = HasParent;
    }
    public boolean getHasParent(){
        return this.HasParent;
    }
    public void setInProgressDate(String InProgressDate){
        this.InProgressDate = InProgressDate;
    }
    public String getInProgressDate(){
        return this.InProgressDate;
    }
    public void setIteration(Iteration Iteration){
        this.Iteration = Iteration;
    }
    public Iteration getIteration(){
        return this.Iteration;
    }
    public void setParent(String Parent){
        this.Parent = Parent;
    }
    public String getParent(){
        return this.Parent;
    }
    public void setPlanEstimate(int PlanEstimate){
        this.PlanEstimate = PlanEstimate;
    }
    public int getPlanEstimate(){
        return this.PlanEstimate;
    }
    public void setPredecessors(Predecessors Predecessors){
        this.Predecessors = Predecessors;
    }
    public Predecessors getPredecessors(){
        return this.Predecessors;
    }
    public void setRecycled(boolean Recycled){
        this.Recycled = Recycled;
    }
    public boolean getRecycled(){
        return this.Recycled;
    }
    public void setRelease(Release Release){
        this.Release = Release;
    }
    public Release getRelease(){
        return this.Release;
    }
    public void setSuccessors(Successors Successors){
        this.Successors = Successors;
    }
    public Successors getSuccessors(){
        return this.Successors;
    }
    public void setTaskActualTotal(int TaskActualTotal){
        this.TaskActualTotal = TaskActualTotal;
    }
    public int getTaskActualTotal(){
        return this.TaskActualTotal;
    }
    public void setTaskEstimateTotal(int TaskEstimateTotal){
        this.TaskEstimateTotal = TaskEstimateTotal;
    }
    public int getTaskEstimateTotal(){
        return this.TaskEstimateTotal;
    }
    public void setTaskRemainingTotal(int TaskRemainingTotal){
        this.TaskRemainingTotal = TaskRemainingTotal;
    }
    public int getTaskRemainingTotal(){
        return this.TaskRemainingTotal;
    }
    public void setTaskStatus(String TaskStatus){
        this.TaskStatus = TaskStatus;
    }
    public String getTaskStatus(){
        return this.TaskStatus;
    }
    public void setTasks(Tasks Tasks){
        this.Tasks = Tasks;
    }
    public Tasks getTasks(){
        return this.Tasks;
    }
    public void setTestCaseStatus(String TestCaseStatus){
        this.TestCaseStatus = TestCaseStatus;
    }
    public String getTestCaseStatus(){
        return this.TestCaseStatus;
    }
    public void setTestCases(TestCases TestCases){
        this.TestCases = TestCases;
    }
    public TestCases getTestCases(){
        return this.TestCases;
    }
    public void setC_AcceptanceCriteria(String c_AcceptanceCriteria){
        this.c_AcceptanceCriteria = c_AcceptanceCriteria;
    }
    public String getC_AcceptanceCriteria(){
        return this.c_AcceptanceCriteria;
    }
    public void setC_AcceptanceCriteriaFilled(boolean c_AcceptanceCriteriaFilled){
        this.c_AcceptanceCriteriaFilled = c_AcceptanceCriteriaFilled;
    }
    public boolean getC_AcceptanceCriteriaFilled(){
        return this.c_AcceptanceCriteriaFilled;
    }
    public void setC_AgileMaturityMeasurement05(String c_AgileMaturityMeasurement05){
        this.c_AgileMaturityMeasurement05 = c_AgileMaturityMeasurement05;
    }
    public String getC_AgileMaturityMeasurement05(){
        return this.c_AgileMaturityMeasurement05;
    }
    public void setC_BacklogQuality(String c_BacklogQuality){
        this.c_BacklogQuality = c_BacklogQuality;
    }
    public String getC_BacklogQuality(){
        return this.c_BacklogQuality;
    }
    public void setC_BusinessValue(String c_BusinessValue){
        this.c_BusinessValue = c_BusinessValue;
    }
    public String getC_BusinessValue(){
        return this.c_BusinessValue;
    }
    public void setC_Deliverysatisfactionscore110(String c_Deliverysatisfactionscore110){
        this.c_Deliverysatisfactionscore110 = c_Deliverysatisfactionscore110;
    }
    public String getC_Deliverysatisfactionscore110(){
        return this.c_Deliverysatisfactionscore110;
    }
    public void setC_Drivers(String c_Drivers){
        this.c_Drivers = c_Drivers;
    }
    public String getC_Drivers(){
        return this.c_Drivers;
    }
    public void setC_DueDate(String c_DueDate){
        this.c_DueDate = c_DueDate;
    }
    public String getC_DueDate(){
        return this.c_DueDate;
    }
    public void setC_Excludefromcalculations(boolean c_Excludefromcalculations){
        this.c_Excludefromcalculations = c_Excludefromcalculations;
    }
    public boolean getC_Excludefromcalculations(){
        return this.c_Excludefromcalculations;
    }
    public void setFeature(Feature Feature){
        this.Feature = Feature;
    }
    public Feature getFeature(){
        return this.Feature;
    }
    public void setC_FunctionalCategory(String c_FunctionalCategory){
        this.c_FunctionalCategory = c_FunctionalCategory;
    }
    public String getC_FunctionalCategory(){
        return this.c_FunctionalCategory;
    }
    public void setC_IdeaURL(C_IdeaURL c_IdeaURL){
        this.c_IdeaURL = c_IdeaURL;
    }
    public C_IdeaURL getC_IdeaURL(){
        return this.c_IdeaURL;
    }
    public void setC_KTToDS(boolean c_KTToDS){
        this.c_KTToDS = c_KTToDS;
    }
    public boolean getC_KTToDS(){
        return this.c_KTToDS;
    }
    public void setC_KTToOperation(boolean c_KTToOperation){
        this.c_KTToOperation = c_KTToOperation;
    }
    public boolean getC_KTToOperation(){
        return this.c_KTToOperation;
    }
    public void setC_LPTest(String c_LPTest){
        this.c_LPTest = c_LPTest;
    }
    public String getC_LPTest(){
        return this.c_LPTest;
    }
    public void setC_LPCVelocity(String c_LPCVelocity){
        this.c_LPCVelocity = c_LPCVelocity;
    }
    public String getC_LPCVelocity(){
        return this.c_LPCVelocity;
    }
    public void setC_Managementinformationrequest(String c_Managementinformationrequest){
        this.c_Managementinformationrequest = c_Managementinformationrequest;
    }
    public String getC_Managementinformationrequest(){
        return this.c_Managementinformationrequest;
    }
    public void setC_MoSCoWPriority(String c_MoSCoWPriority){
        this.c_MoSCoWPriority = c_MoSCoWPriority;
    }
    public String getC_MoSCoWPriority(){
        return this.c_MoSCoWPriority;
    }
    public void setC_OldHealthCareWorkspace(String c_OldHealthCareWorkspace){
        this.c_OldHealthCareWorkspace = c_OldHealthCareWorkspace;
    }
    public String getC_OldHealthCareWorkspace(){
        return this.c_OldHealthCareWorkspace;
    }
    public void setPortfolioItem(PortfolioItem PortfolioItem){
        this.PortfolioItem = PortfolioItem;
    }
    public PortfolioItem getPortfolioItem(){
        return this.PortfolioItem;
    }
    public void setC_ProductOwnerInvolvement15(String c_ProductOwnerInvolvement15){
        this.c_ProductOwnerInvolvement15 = c_ProductOwnerInvolvement15;
    }
    public String getC_ProductOwnerInvolvement15(){
        return this.c_ProductOwnerInvolvement15;
    }
    public void setC_ProductOwners(String c_ProductOwners){
        this.c_ProductOwners = c_ProductOwners;
    }
    public String getC_ProductOwners(){
        return this.c_ProductOwners;
    }
    public void setC_ProgressStage(String c_ProgressStage){
        this.c_ProgressStage = c_ProgressStage;
    }
    public String getC_ProgressStage(){
        return this.c_ProgressStage;
    }
    public void setC_RCB(String c_RCB){
        this.c_RCB = c_RCB;
    }
    public String getC_RCB(){
        return this.c_RCB;
    }
    public void setC_ReadyKanbanState(String c_ReadyKanbanState){
        this.c_ReadyKanbanState = c_ReadyKanbanState;
    }
    public String getC_ReadyKanbanState(){
        return this.c_ReadyKanbanState;
    }
    public void setC_RegressionTest(String c_RegressionTest){
        this.c_RegressionTest = c_RegressionTest;
    }
    public String getC_RegressionTest(){
        return this.c_RegressionTest;
    }
    public void setC_ReleaseComments(String c_ReleaseComments){
        this.c_ReleaseComments = c_ReleaseComments;
    }
    public String getC_ReleaseComments(){
        return this.c_ReleaseComments;
    }
    public void setC_Retrospectiveactions(String c_Retrospectiveactions){
        this.c_Retrospectiveactions = c_Retrospectiveactions;
    }
    public String getC_Retrospectiveactions(){
        return this.c_Retrospectiveactions;
    }
    public void setC_Retrospectivenotes(String c_Retrospectivenotes){
        this.c_Retrospectivenotes = c_Retrospectivenotes;
    }
    public String getC_Retrospectivenotes(){
        return this.c_Retrospectivenotes;
    }
    public void setC_RiskDateIdentified(String c_RiskDateIdentified){
        this.c_RiskDateIdentified = c_RiskDateIdentified;
    }
    public String getC_RiskDateIdentified(){
        return this.c_RiskDateIdentified;
    }
    public void setC_RiskImpact(String c_RiskImpact){
        this.c_RiskImpact = c_RiskImpact;
    }
    public String getC_RiskImpact(){
        return this.c_RiskImpact;
    }
    public void setC_RiskPeriodpossibleoccurrence(String c_RiskPeriodpossibleoccurrence){
        this.c_RiskPeriodpossibleoccurrence = c_RiskPeriodpossibleoccurrence;
    }
    public String getC_RiskPeriodpossibleoccurrence(){
        return this.c_RiskPeriodpossibleoccurrence;
    }
    public void setC_RiskProbability(String c_RiskProbability){
        this.c_RiskProbability = c_RiskProbability;
    }
    public String getC_RiskProbability(){
        return this.c_RiskProbability;
    }
    public void setC_RiskResponsestrategy(String c_RiskResponsestrategy){
        this.c_RiskResponsestrategy = c_RiskResponsestrategy;
    }
    public String getC_RiskResponsestrategy(){
        return this.c_RiskResponsestrategy;
    }
    public void setC_RiskResponsestrategydescription(String c_RiskResponsestrategydescription){
        this.c_RiskResponsestrategydescription = c_RiskResponsestrategydescription;
    }
    public String getC_RiskResponsestrategydescription(){
        return this.c_RiskResponsestrategydescription;
    }
    public void setC_RiskSymtomsTriggers(String c_RiskSymtomsTriggers){
        this.c_RiskSymtomsTriggers = c_RiskSymtomsTriggers;
    }
    public String getC_RiskSymtomsTriggers(){
        return this.c_RiskSymtomsTriggers;
    }
    public void setC_ScopetopicID(String c_ScopetopicID){
        this.c_ScopetopicID = c_ScopetopicID;
    }
    public String getC_ScopetopicID(){
        return this.c_ScopetopicID;
    }
    public void setC_SIT(String c_SIT){
        this.c_SIT = c_SIT;
    }
    public String getC_SIT(){
        return this.c_SIT;
    }
    public void setC_SM7ChangeID(String c_SM7ChangeID){
        this.c_SM7ChangeID = c_SM7ChangeID;
    }
    public String getC_SM7ChangeID(){
        return this.c_SM7ChangeID;
    }
    public void setC_SpecificationDSID(String c_SpecificationDSID){
        this.c_SpecificationDSID = c_SpecificationDSID;
    }
    public String getC_SpecificationDSID(){
        return this.c_SpecificationDSID;
    }
    public void setC_SpecificationFRSID(String c_SpecificationFRSID){
        this.c_SpecificationFRSID = c_SpecificationFRSID;
    }
    public String getC_SpecificationFRSID(){
        return this.c_SpecificationFRSID;
    }
    public void setC_SpecificationURSID(String c_SpecificationURSID){
        this.c_SpecificationURSID = c_SpecificationURSID;
    }
    public String getC_SpecificationURSID(){
        return this.c_SpecificationURSID;
    }
    public void setC_TeamLifecycle(String c_TeamLifecycle){
        this.c_TeamLifecycle = c_TeamLifecycle;
    }
    public String getC_TeamLifecycle(){
        return this.c_TeamLifecycle;
    }
    public void setC_TeamSize(String c_TeamSize){
        this.c_TeamSize = c_TeamSize;
    }
    public String getC_TeamSize(){
        return this.c_TeamSize;
    }
    public void setC_Teamstatus(String c_Teamstatus){
        this.c_Teamstatus = c_Teamstatus;
    }
    public String getC_Teamstatus(){
        return this.c_Teamstatus;
    }
    public void setC_TestCoordinator(String c_TestCoordinator){
        this.c_TestCoordinator = c_TestCoordinator;
    }
    public String getC_TestCoordinator(){
        return this.c_TestCoordinator;
    }
    public void setC_USStatus(String c_USStatus){
        this.c_USStatus = c_USStatus;
    }
    public String getC_USStatus(){
        return this.c_USStatus;
    }
    public void setC_UserSponsor(String c_UserSponsor){
        this.c_UserSponsor = c_UserSponsor;
    }
    public String getC_UserSponsor(){
        return this.c_UserSponsor;
    }
    public void setC_VelocityBaselineOverwrite(String c_VelocityBaselineOverwrite){
        this.c_VelocityBaselineOverwrite = c_VelocityBaselineOverwrite;
    }
    public String getC_VelocityBaselineOverwrite(){
        return this.c_VelocityBaselineOverwrite;
    }
    public void setC_zzobsoleteboolean1(boolean c_zzobsoleteboolean1){
        this.c_zzobsoleteboolean1 = c_zzobsoleteboolean1;
    }
    public boolean getC_zzobsoleteboolean1(){
        return this.c_zzobsoleteboolean1;
    }
    public void setC_zzobsoleteRiskSymtomsTriggers(String c_zzobsoleteRiskSymtomsTriggers){
        this.c_zzobsoleteRiskSymtomsTriggers = c_zzobsoleteRiskSymtomsTriggers;
    }
    public String getC_zzobsoleteRiskSymtomsTriggers(){
        return this.c_zzobsoleteRiskSymtomsTriggers;
    }
    public void setC_zzobsoletestring1(String c_zzobsoletestring1){
        this.c_zzobsoletestring1 = c_zzobsoletestring1;
    }
    public String getC_zzobsoletestring1(){
        return this.c_zzobsoletestring1;
    }
    public void set_type(String _type){
        this._type = _type;
    }
    public String get_type(){
        return this._type;
    }
}
