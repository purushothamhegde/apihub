package com.philips.apihub.ca.rally;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Feature
{
    private String _rallyAPIMajor;

    private String _rallyAPIMinor;

    private String _ref;

    private String _refObjectUUID;

    private String _objectVersion;

    private String _refObjectName;

    @JsonProperty("_type")
    private String _type;
    
    @JsonProperty("CreationDate")  
    private String CreationDate;

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

    @JsonProperty("AcceptedLeafStoryCount")
    private int AcceptedLeafStoryCount;

    @JsonProperty("AcceptedLeafStoryPlanEstimateTotal")
    private int AcceptedLeafStoryPlanEstimateTotal;

    @JsonProperty("ActualEndDate")
    private String ActualEndDate;

    @JsonProperty("ActualStartDate")
    private String ActualStartDate;

    @JsonProperty("Archived")
    private boolean Archived;

    @JsonProperty("Attachments")
    private Attachments Attachments;

    @JsonProperty("Collaborators")
    private Collaborators Collaborators;

    @JsonProperty("DirectChildrenCount")
    private int DirectChildrenCount;

    @JsonProperty("DragAndDropRank")
    private String DragAndDropRank;

    @JsonProperty("InvestmentCategory")
    private String InvestmentCategory;

    @JsonProperty("Investments")
    private Investments Investments;

    @JsonProperty("JobSize")
    private int JobSize;

    @JsonProperty("LeafStoryCount")
    private int LeafStoryCount;

    @JsonProperty("LeafStoryPlanEstimateTotal")
    private int LeafStoryPlanEstimateTotal;

    @JsonProperty("PercentDoneByStoryCount")
    private double PercentDoneByStoryCount;

    @JsonProperty("PercentDoneByStoryPlanEstimate")
    private double PercentDoneByStoryPlanEstimate;

    @JsonProperty("PlannedEndDate")
    private String PlannedEndDate;

    @JsonProperty("PlannedStartDate")
    private String PlannedStartDate;

    @JsonProperty("PortfolioItemType")
    private PortfolioItemType PortfolioItemType;

    @JsonProperty("PortfolioItemTypeName")
    private String PortfolioItemTypeName;

    @JsonProperty("PreliminaryEstimate")
    private PreliminaryEstimate PreliminaryEstimate;

    @JsonProperty("PreliminaryEstimateValue")
    private int PreliminaryEstimateValue;

    @JsonProperty("Recycled")
    private boolean Recycled;

    @JsonProperty("RefinedEstimate")
    private int RefinedEstimate;

    @JsonProperty("RiskScore")
    private int RiskScore;

    @JsonProperty("RROEValue")
    private int RROEValue;

    @JsonProperty("StateChangedDate")
    private String StateChangedDate;

    @JsonProperty("TimeCriticality")
    private int TimeCriticality;

    @JsonProperty("UnEstimatedLeafStoryCount")
    private int UnEstimatedLeafStoryCount;

    @JsonProperty("UserBusinessValue")
    private int UserBusinessValue;

    @JsonProperty("ValueScore")
    private int ValueScore;

    @JsonProperty("WSJFScore")
    private int WSJFScore;

    @JsonProperty("c_ArchitecturalEpicState")
    private String c_ArchitecturalEpicState;

    @JsonProperty("c_Blocked")
    private boolean c_Blocked;

    @JsonProperty("c_BlockedActionOwner")
    private String c_BlockedActionOwner;

    @JsonProperty("c_BlockedReason")
    private String c_BlockedReason;

    @JsonProperty("c_BusinessProcessLink")
    private String c_BusinessProcessLink;

    @JsonProperty("c_E2EFeatureFlow")
    private String c_E2EFeatureFlow;

    @JsonProperty("c_obsolete")
    private boolean c_obsolete;

    @JsonProperty("c_RPSplannedenddate")
    private String c_RPSplannedenddate;

    @JsonProperty("c_RPSplannedstartdate")
    private String c_RPSplannedstartdate;

    @JsonProperty("c_ScopeID")
    private String c_ScopeID;

    @JsonProperty("c_UnblockDueDate")
    private String c_UnblockDueDate;

    @JsonProperty("LateChildCount")
    private int LateChildCount;

    @JsonProperty("Predecessors")
    private Predecessors Predecessors;

    @JsonProperty("Release")
    private Release Release;

    @JsonProperty("State")
    private State State;

    @JsonProperty("Successors")
    private Successors Successors;

    @JsonProperty("UserStories")
    private UserStories UserStories;

    @JsonProperty("Errors")
    private List<String> Errors;

    @JsonProperty("Warnings")
    private List<String> Warnings;

    
    
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
    public void setAcceptedLeafStoryCount(int AcceptedLeafStoryCount){
        this.AcceptedLeafStoryCount = AcceptedLeafStoryCount;
    }
    public int getAcceptedLeafStoryCount(){
        return this.AcceptedLeafStoryCount;
    }
    public void setAcceptedLeafStoryPlanEstimateTotal(int AcceptedLeafStoryPlanEstimateTotal){
        this.AcceptedLeafStoryPlanEstimateTotal = AcceptedLeafStoryPlanEstimateTotal;
    }
    public int getAcceptedLeafStoryPlanEstimateTotal(){
        return this.AcceptedLeafStoryPlanEstimateTotal;
    }
    public void setActualEndDate(String ActualEndDate){
        this.ActualEndDate = ActualEndDate;
    }
    public String getActualEndDate(){
        return this.ActualEndDate;
    }
    public void setActualStartDate(String ActualStartDate){
        this.ActualStartDate = ActualStartDate;
    }
    public String getActualStartDate(){
        return this.ActualStartDate;
    }
    public void setArchived(boolean Archived){
        this.Archived = Archived;
    }
    public boolean getArchived(){
        return this.Archived;
    }
    public void setAttachments(Attachments Attachments){
        this.Attachments = Attachments;
    }
    public Attachments getAttachments(){
        return this.Attachments;
    }
    public void setCollaborators(Collaborators Collaborators){
        this.Collaborators = Collaborators;
    }
    public Collaborators getCollaborators(){
        return this.Collaborators;
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
    public void setInvestmentCategory(String InvestmentCategory){
        this.InvestmentCategory = InvestmentCategory;
    }
    public String getInvestmentCategory(){
        return this.InvestmentCategory;
    }
    public void setInvestments(Investments Investments){
        this.Investments = Investments;
    }
    public Investments getInvestments(){
        return this.Investments;
    }
    public void setJobSize(int JobSize){
        this.JobSize = JobSize;
    }
    public int getJobSize(){
        return this.JobSize;
    }
    public void setLeafStoryCount(int LeafStoryCount){
        this.LeafStoryCount = LeafStoryCount;
    }
    public int getLeafStoryCount(){
        return this.LeafStoryCount;
    }
    public void setLeafStoryPlanEstimateTotal(int LeafStoryPlanEstimateTotal){
        this.LeafStoryPlanEstimateTotal = LeafStoryPlanEstimateTotal;
    }
    public int getLeafStoryPlanEstimateTotal(){
        return this.LeafStoryPlanEstimateTotal;
    }
    public void setPercentDoneByStoryCount(double PercentDoneByStoryCount){
        this.PercentDoneByStoryCount = PercentDoneByStoryCount;
    }
    public double getPercentDoneByStoryCount(){
        return this.PercentDoneByStoryCount;
    }
    public void setPercentDoneByStoryPlanEstimate(double PercentDoneByStoryPlanEstimate){
        this.PercentDoneByStoryPlanEstimate = PercentDoneByStoryPlanEstimate;
    }
    public double getPercentDoneByStoryPlanEstimate(){
        return this.PercentDoneByStoryPlanEstimate;
    }
    public void setPlannedEndDate(String PlannedEndDate){
        this.PlannedEndDate = PlannedEndDate;
    }
    public String getPlannedEndDate(){
        return this.PlannedEndDate;
    }
    public void setPlannedStartDate(String PlannedStartDate){
        this.PlannedStartDate = PlannedStartDate;
    }
    public String getPlannedStartDate(){
        return this.PlannedStartDate;
    }
    public void setPortfolioItemType(PortfolioItemType PortfolioItemType){
        this.PortfolioItemType = PortfolioItemType;
    }
    public PortfolioItemType getPortfolioItemType(){
        return this.PortfolioItemType;
    }
    public void setPortfolioItemTypeName(String PortfolioItemTypeName){
        this.PortfolioItemTypeName = PortfolioItemTypeName;
    }
    public String getPortfolioItemTypeName(){
        return this.PortfolioItemTypeName;
    }
    public void setPreliminaryEstimate(PreliminaryEstimate PreliminaryEstimate){
        this.PreliminaryEstimate = PreliminaryEstimate;
    }
    public PreliminaryEstimate getPreliminaryEstimate(){
        return this.PreliminaryEstimate;
    }
    public void setPreliminaryEstimateValue(int PreliminaryEstimateValue){
        this.PreliminaryEstimateValue = PreliminaryEstimateValue;
    }
    public int getPreliminaryEstimateValue(){
        return this.PreliminaryEstimateValue;
    }
    public void setRecycled(boolean Recycled){
        this.Recycled = Recycled;
    }
    public boolean getRecycled(){
        return this.Recycled;
    }
    public void setRefinedEstimate(int RefinedEstimate){
        this.RefinedEstimate = RefinedEstimate;
    }
    public int getRefinedEstimate(){
        return this.RefinedEstimate;
    }
    public void setRiskScore(int RiskScore){
        this.RiskScore = RiskScore;
    }
    public int getRiskScore(){
        return this.RiskScore;
    }
    public void setRROEValue(int RROEValue){
        this.RROEValue = RROEValue;
    }
    public int getRROEValue(){
        return this.RROEValue;
    }
    public void setStateChangedDate(String StateChangedDate){
        this.StateChangedDate = StateChangedDate;
    }
    public String getStateChangedDate(){
        return this.StateChangedDate;
    }
    public void setTimeCriticality(int TimeCriticality){
        this.TimeCriticality = TimeCriticality;
    }
    public int getTimeCriticality(){
        return this.TimeCriticality;
    }
    public void setUnEstimatedLeafStoryCount(int UnEstimatedLeafStoryCount){
        this.UnEstimatedLeafStoryCount = UnEstimatedLeafStoryCount;
    }
    public int getUnEstimatedLeafStoryCount(){
        return this.UnEstimatedLeafStoryCount;
    }
    public void setUserBusinessValue(int UserBusinessValue){
        this.UserBusinessValue = UserBusinessValue;
    }
    public int getUserBusinessValue(){
        return this.UserBusinessValue;
    }
    public void setValueScore(int ValueScore){
        this.ValueScore = ValueScore;
    }
    public int getValueScore(){
        return this.ValueScore;
    }
    public void setWSJFScore(int WSJFScore){
        this.WSJFScore = WSJFScore;
    }
    public int getWSJFScore(){
        return this.WSJFScore;
    }
    public void setC_ArchitecturalEpicState(String c_ArchitecturalEpicState){
        this.c_ArchitecturalEpicState = c_ArchitecturalEpicState;
    }
    public String getC_ArchitecturalEpicState(){
        return this.c_ArchitecturalEpicState;
    }
    public void setC_Blocked(boolean c_Blocked){
        this.c_Blocked = c_Blocked;
    }
    public boolean getC_Blocked(){
        return this.c_Blocked;
    }
    public void setC_BlockedActionOwner(String c_BlockedActionOwner){
        this.c_BlockedActionOwner = c_BlockedActionOwner;
    }
    public String getC_BlockedActionOwner(){
        return this.c_BlockedActionOwner;
    }
    public void setC_BlockedReason(String c_BlockedReason){
        this.c_BlockedReason = c_BlockedReason;
    }
    public String getC_BlockedReason(){
        return this.c_BlockedReason;
    }
    public void setC_BusinessProcessLink(String c_BusinessProcessLink){
        this.c_BusinessProcessLink = c_BusinessProcessLink;
    }
    public String getC_BusinessProcessLink(){
        return this.c_BusinessProcessLink;
    }
    public void setC_E2EFeatureFlow(String c_E2EFeatureFlow){
        this.c_E2EFeatureFlow = c_E2EFeatureFlow;
    }
    public String getC_E2EFeatureFlow(){
        return this.c_E2EFeatureFlow;
    }
    public void setC_obsolete(boolean c_obsolete){
        this.c_obsolete = c_obsolete;
    }
    public boolean getC_obsolete(){
        return this.c_obsolete;
    }
    public void setC_RPSplannedenddate(String c_RPSplannedenddate){
        this.c_RPSplannedenddate = c_RPSplannedenddate;
    }
    public String getC_RPSplannedenddate(){
        return this.c_RPSplannedenddate;
    }
    public void setC_RPSplannedstartdate(String c_RPSplannedstartdate){
        this.c_RPSplannedstartdate = c_RPSplannedstartdate;
    }
    public String getC_RPSplannedstartdate(){
        return this.c_RPSplannedstartdate;
    }
    public void setC_ScopeID(String c_ScopeID){
        this.c_ScopeID = c_ScopeID;
    }
    public String getC_ScopeID(){
        return this.c_ScopeID;
    }
    public void setC_UnblockDueDate(String c_UnblockDueDate){
        this.c_UnblockDueDate = c_UnblockDueDate;
    }
    public String getC_UnblockDueDate(){
        return this.c_UnblockDueDate;
    }
    public void setLateChildCount(int LateChildCount){
        this.LateChildCount = LateChildCount;
    }
    public int getLateChildCount(){
        return this.LateChildCount;
    }
    public void setPredecessors(Predecessors Predecessors){
        this.Predecessors = Predecessors;
    }
    public Predecessors getPredecessors(){
        return this.Predecessors;
    }
    public void setRelease(Release Release){
        this.Release = Release;
    }
    public Release getRelease(){
        return this.Release;
    }
    public void setState(State State){
        this.State = State;
    }
    public State getState(){
        return this.State;
    }
    public void setSuccessors(Successors Successors){
        this.Successors = Successors;
    }
    public Successors getSuccessors(){
        return this.Successors;
    }
    public void setUserStories(UserStories UserStories){
        this.UserStories = UserStories;
    }
    public UserStories getUserStories(){
        return this.UserStories;
    }
    public void setErrors(List<String> Errors){
        this.Errors = Errors;
    }
    public List<String> getErrors(){
        return this.Errors;
    }
    public void setWarnings(List<String> Warnings){
        this.Warnings = Warnings;
    }
    public List<String> getWarnings(){
        return this.Warnings;
    }

    public void set_type(String _type){
        this._type = _type;
    }
    public String get_type(){
        return this._type;
    }

}
