
package gov.va.med.esr.webservices.jaxws.schemas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.va.med.esr.webservices.jaxws.schemas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDeliveryPreferenceRequest_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "getDeliveryPreferenceRequest");
    private final static QName _GetEligibilityDeterminationRequest_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "getEligibilityDeterminationRequest");
    private final static QName _GetDeliveryPreferenceResponse_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "getDeliveryPreferenceResponse");
    private final static QName _GetEligibilityDeterminationResponse_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "getEligibilityDeterminationResponse");
    private final static QName _GetEESummaryRequest_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "getEESummaryRequest");
    private final static QName _GetEESummaryHistoryRequest_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "getEESummaryHistoryRequest");
    private final static QName _UpdateDeliveryPreferenceRequest_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "updateDeliveryPreferenceRequest");
    private final static QName _UpdateDeliveryPreferenceResponse_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "updateDeliveryPreferenceResponse");
    private final static QName _GetIVMLetterStatusesRequest_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "getIVMLetterStatusesRequest");
    private final static QName _GetEESummaryHistoryResponse_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "getEESummaryHistoryResponse");
    private final static QName _GetPersonNotificationRequest_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "getPersonNotificationRequest");
    private final static QName _GetPersonNotificationResponse_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "getPersonNotificationResponse");
    private final static QName _GetEESummaryResponse_QNAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "getEESummaryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.va.med.esr.webservices.jaxws.schemas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendIVMUpdatesRequest }
     * 
     */
    public SendIVMUpdatesRequest createSendIVMUpdatesRequest() {
        return new SendIVMUpdatesRequest();
    }

    /**
     * Create an instance of {@link GetEESummaryHistoryRequest }
     * 
     */
    public GetEESummaryHistoryRequest createGetEESummaryHistoryRequest() {
        return new GetEESummaryHistoryRequest();
    }

    /**
     * Create an instance of {@link UpdateIVMRecordStatusRequest }
     * 
     */
    public UpdateIVMRecordStatusRequest createUpdateIVMRecordStatusRequest() {
        return new UpdateIVMRecordStatusRequest();
    }

    /**
     * Create an instance of {@link GetEESummaryRequest }
     * 
     */
    public GetEESummaryRequest createGetEESummaryRequest() {
        return new GetEESummaryRequest();
    }

    /**
     * Create an instance of {@link GetEESummaryHistoryResponse }
     * 
     */
    public GetEESummaryHistoryResponse createGetEESummaryHistoryResponse() {
        return new GetEESummaryHistoryResponse();
    }

    /**
     * Create an instance of {@link UpdateDeliveryPreferenceResponse }
     * 
     */
    public UpdateDeliveryPreferenceResponse createUpdateDeliveryPreferenceResponse() {
        return new UpdateDeliveryPreferenceResponse();
    }

    /**
     * Create an instance of {@link GetIVMLetterStatusesRequest }
     * 
     */
    public GetIVMLetterStatusesRequest createGetIVMLetterStatusesRequest() {
        return new GetIVMLetterStatusesRequest();
    }

    /**
     * Create an instance of {@link UpdateDeliveryPreferenceRequest }
     * 
     */
    public UpdateDeliveryPreferenceRequest createUpdateDeliveryPreferenceRequest() {
        return new UpdateDeliveryPreferenceRequest();
    }

    /**
     * Create an instance of {@link UpdateIVMRecordStatusResponse }
     * 
     */
    public UpdateIVMRecordStatusResponse createUpdateIVMRecordStatusResponse() {
        return new UpdateIVMRecordStatusResponse();
    }

    /**
     * Create an instance of {@link SendIVMUpdatesResponse }
     * 
     */
    public SendIVMUpdatesResponse createSendIVMUpdatesResponse() {
        return new SendIVMUpdatesResponse();
    }

    /**
     * Create an instance of {@link GetEESummaryResponse }
     * 
     */
    public GetEESummaryResponse createGetEESummaryResponse() {
        return new GetEESummaryResponse();
    }

    /**
     * Create an instance of {@link GetPersonNotificationResponse }
     * 
     */
    public GetPersonNotificationResponse createGetPersonNotificationResponse() {
        return new GetPersonNotificationResponse();
    }

    /**
     * Create an instance of {@link GetPersonNotificationRequest }
     * 
     */
    public GetPersonNotificationRequest createGetPersonNotificationRequest() {
        return new GetPersonNotificationRequest();
    }

    /**
     * Create an instance of {@link GetDeliveryPreferenceRequest }
     * 
     */
    public GetDeliveryPreferenceRequest createGetDeliveryPreferenceRequest() {
        return new GetDeliveryPreferenceRequest();
    }

    /**
     * Create an instance of {@link GetIVMLetterStatusesResponse }
     * 
     */
    public GetIVMLetterStatusesResponse createGetIVMLetterStatusesResponse() {
        return new GetIVMLetterStatusesResponse();
    }

    /**
     * Create an instance of {@link IvmLetterCandidateCollection }
     * 
     */
    public IvmLetterCandidateCollection createIvmLetterCandidateCollection() {
        return new IvmLetterCandidateCollection();
    }

    /**
     * Create an instance of {@link RetrieveIVMCandidatesResponse }
     * 
     */
    public RetrieveIVMCandidatesResponse createRetrieveIVMCandidatesResponse() {
        return new RetrieveIVMCandidatesResponse();
    }

    /**
     * Create an instance of {@link IvmCandidateCollection }
     * 
     */
    public IvmCandidateCollection createIvmCandidateCollection() {
        return new IvmCandidateCollection();
    }

    /**
     * Create an instance of {@link SendIVMUpdatesRequest.SendIVMInfo }
     * 
     */
    public SendIVMUpdatesRequest.SendIVMInfo createSendIVMUpdatesRequestSendIVMInfo() {
        return new SendIVMUpdatesRequest.SendIVMInfo();
    }

    /**
     * Create an instance of {@link SendIVMUpdatesRequest.IvmLetterInfo }
     * 
     */
    public SendIVMUpdatesRequest.IvmLetterInfo createSendIVMUpdatesRequestIvmLetterInfo() {
        return new SendIVMUpdatesRequest.IvmLetterInfo();
    }

    /**
     * Create an instance of {@link GetEligibilityDeterminationResponse }
     * 
     */
    public GetEligibilityDeterminationResponse createGetEligibilityDeterminationResponse() {
        return new GetEligibilityDeterminationResponse();
    }

    /**
     * Create an instance of {@link RetrieveIVMCandidatesRequest }
     * 
     */
    public RetrieveIVMCandidatesRequest createRetrieveIVMCandidatesRequest() {
        return new RetrieveIVMCandidatesRequest();
    }

    /**
     * Create an instance of {@link GetDeliveryPreferenceResponse }
     * 
     */
    public GetDeliveryPreferenceResponse createGetDeliveryPreferenceResponse() {
        return new GetDeliveryPreferenceResponse();
    }

    /**
     * Create an instance of {@link GetEligibilityDeterminationRequest }
     * 
     */
    public GetEligibilityDeterminationRequest createGetEligibilityDeterminationRequest() {
        return new GetEligibilityDeterminationRequest();
    }

    /**
     * Create an instance of {@link CommunityCareEligibilityInfo }
     * 
     */
    public CommunityCareEligibilityInfo createCommunityCareEligibilityInfo() {
        return new CommunityCareEligibilityInfo();
    }

    /**
     * Create an instance of {@link ConfidentialAddressCategoryCollection }
     * 
     */
    public ConfidentialAddressCategoryCollection createConfidentialAddressCategoryCollection() {
        return new ConfidentialAddressCategoryCollection();
    }

    /**
     * Create an instance of {@link SsnInfo }
     * 
     */
    public SsnInfo createSsnInfo() {
        return new SsnInfo();
    }

    /**
     * Create an instance of {@link SpinalCordInjuryInfo }
     * 
     */
    public SpinalCordInjuryInfo createSpinalCordInjuryInfo() {
        return new SpinalCordInjuryInfo();
    }

    /**
     * Create an instance of {@link IvmLetterCandidateInfo }
     * 
     */
    public IvmLetterCandidateInfo createIvmLetterCandidateInfo() {
        return new IvmLetterCandidateInfo();
    }

    /**
     * Create an instance of {@link NoseThroatRadiumInfo }
     * 
     */
    public NoseThroatRadiumInfo createNoseThroatRadiumInfo() {
        return new NoseThroatRadiumInfo();
    }

    /**
     * Create an instance of {@link HealthBenefitPlanInfo }
     * 
     */
    public HealthBenefitPlanInfo createHealthBenefitPlanInfo() {
        return new HealthBenefitPlanInfo();
    }

    /**
     * Create an instance of {@link IvmCandidateInfo }
     * 
     */
    public IvmCandidateInfo createIvmCandidateInfo() {
        return new IvmCandidateInfo();
    }

    /**
     * Create an instance of {@link ConsentInfo }
     * 
     */
    public ConsentInfo createConsentInfo() {
        return new ConsentInfo();
    }

    /**
     * Create an instance of {@link RaceCollection }
     * 
     */
    public RaceCollection createRaceCollection() {
        return new RaceCollection();
    }

    /**
     * Create an instance of {@link InsuranceInfo }
     * 
     */
    public InsuranceInfo createInsuranceInfo() {
        return new InsuranceInfo();
    }

    /**
     * Create an instance of {@link IncomeTestStatusCollection }
     * 
     */
    public IncomeTestStatusCollection createIncomeTestStatusCollection() {
        return new IncomeTestStatusCollection();
    }

    /**
     * Create an instance of {@link EligibilityStatusInfo }
     * 
     */
    public EligibilityStatusInfo createEligibilityStatusInfo() {
        return new EligibilityStatusInfo();
    }

    /**
     * Create an instance of {@link AddressInfo }
     * 
     */
    public AddressInfo createAddressInfo() {
        return new AddressInfo();
    }

    /**
     * Create an instance of {@link ServiceConnectionAwardInfo }
     * 
     */
    public ServiceConnectionAwardInfo createServiceConnectionAwardInfo() {
        return new ServiceConnectionAwardInfo();
    }

    /**
     * Create an instance of {@link EmploymentInfo }
     * 
     */
    public EmploymentInfo createEmploymentInfo() {
        return new EmploymentInfo();
    }

    /**
     * Create an instance of {@link FeeBasisInfo }
     * 
     */
    public FeeBasisInfo createFeeBasisInfo() {
        return new FeeBasisInfo();
    }

    /**
     * Create an instance of {@link CombatEpisodeInfo }
     * 
     */
    public CombatEpisodeInfo createCombatEpisodeInfo() {
        return new CombatEpisodeInfo();
    }

    /**
     * Create an instance of {@link SpecialFactorsInfo }
     * 
     */
    public SpecialFactorsInfo createSpecialFactorsInfo() {
        return new SpecialFactorsInfo();
    }

    /**
     * Create an instance of {@link PreferredFacilityCollection }
     * 
     */
    public PreferredFacilityCollection createPreferredFacilityCollection() {
        return new PreferredFacilityCollection();
    }

    /**
     * Create an instance of {@link PrimaryviewNotificationInfo }
     * 
     */
    public PrimaryviewNotificationInfo createPrimaryviewNotificationInfo() {
        return new PrimaryviewNotificationInfo();
    }

    /**
     * Create an instance of {@link ExpenseCollection }
     * 
     */
    public ExpenseCollection createExpenseCollection() {
        return new ExpenseCollection();
    }

    /**
     * Create an instance of {@link IncomeTestStatusInfo }
     * 
     */
    public IncomeTestStatusInfo createIncomeTestStatusInfo() {
        return new IncomeTestStatusInfo();
    }

    /**
     * Create an instance of {@link IvmLetterStatusInfo }
     * 
     */
    public IvmLetterStatusInfo createIvmLetterStatusInfo() {
        return new IvmLetterStatusInfo();
    }

    /**
     * Create an instance of {@link SpouseFinancialsInfo }
     * 
     */
    public SpouseFinancialsInfo createSpouseFinancialsInfo() {
        return new SpouseFinancialsInfo();
    }

    /**
     * Create an instance of {@link ConflictExperienceCollection }
     * 
     */
    public ConflictExperienceCollection createConflictExperienceCollection() {
        return new ConflictExperienceCollection();
    }

    /**
     * Create an instance of {@link EmailInfo }
     * 
     */
    public EmailInfo createEmailInfo() {
        return new EmailInfo();
    }

    /**
     * Create an instance of {@link CdDiagnosisCollection }
     * 
     */
    public CdDiagnosisCollection createCdDiagnosisCollection() {
        return new CdDiagnosisCollection();
    }

    /**
     * Create an instance of {@link CancelDeclineInfo }
     * 
     */
    public CancelDeclineInfo createCancelDeclineInfo() {
        return new CancelDeclineInfo();
    }

    /**
     * Create an instance of {@link DependentFinancialsInfo }
     * 
     */
    public DependentFinancialsInfo createDependentFinancialsInfo() {
        return new DependentFinancialsInfo();
    }

    /**
     * Create an instance of {@link MilitaryServiceSiteRecordInfo }
     * 
     */
    public MilitaryServiceSiteRecordInfo createMilitaryServiceSiteRecordInfo() {
        return new MilitaryServiceSiteRecordInfo();
    }

    /**
     * Create an instance of {@link PowEpisodeInfo }
     * 
     */
    public PowEpisodeInfo createPowEpisodeInfo() {
        return new PowEpisodeInfo();
    }

    /**
     * Create an instance of {@link CdConditionCollection }
     * 
     */
    public CdConditionCollection createCdConditionCollection() {
        return new CdConditionCollection();
    }

    /**
     * Create an instance of {@link VamcInfo }
     * 
     */
    public VamcInfo createVamcInfo() {
        return new VamcInfo();
    }

    /**
     * Create an instance of {@link AssociationCollection }
     * 
     */
    public AssociationCollection createAssociationCollection() {
        return new AssociationCollection();
    }

    /**
     * Create an instance of {@link SpouseInfo }
     * 
     */
    public SpouseInfo createSpouseInfo() {
        return new SpouseInfo();
    }

    /**
     * Create an instance of {@link MonetaryBenefitAwardInfo }
     * 
     */
    public MonetaryBenefitAwardInfo createMonetaryBenefitAwardInfo() {
        return new MonetaryBenefitAwardInfo();
    }

    /**
     * Create an instance of {@link EligibilityInfo }
     * 
     */
    public EligibilityInfo createEligibilityInfo() {
        return new EligibilityInfo();
    }

    /**
     * Create an instance of {@link DeliveryPreferenceInfo }
     * 
     */
    public DeliveryPreferenceInfo createDeliveryPreferenceInfo() {
        return new DeliveryPreferenceInfo();
    }

    /**
     * Create an instance of {@link NameCollection }
     * 
     */
    public NameCollection createNameCollection() {
        return new NameCollection();
    }

    /**
     * Create an instance of {@link EmailCollection }
     * 
     */
    public EmailCollection createEmailCollection() {
        return new EmailCollection();
    }

    /**
     * Create an instance of {@link CatastrophicDisabilityInfo }
     * 
     */
    public CatastrophicDisabilityInfo createCatastrophicDisabilityInfo() {
        return new CatastrophicDisabilityInfo();
    }

    /**
     * Create an instance of {@link MonetaryBenefitInfo }
     * 
     */
    public MonetaryBenefitInfo createMonetaryBenefitInfo() {
        return new MonetaryBenefitInfo();
    }

    /**
     * Create an instance of {@link BeneficiaryTravelInfo }
     * 
     */
    public BeneficiaryTravelInfo createBeneficiaryTravelInfo() {
        return new BeneficiaryTravelInfo();
    }

    /**
     * Create an instance of {@link NameInfo }
     * 
     */
    public NameInfo createNameInfo() {
        return new NameInfo();
    }

    /**
     * Create an instance of {@link FinancialStatementInfo }
     * 
     */
    public FinancialStatementInfo createFinancialStatementInfo() {
        return new FinancialStatementInfo();
    }

    /**
     * Create an instance of {@link ExpenseInfo }
     * 
     */
    public ExpenseInfo createExpenseInfo() {
        return new ExpenseInfo();
    }

    /**
     * Create an instance of {@link CdConditionInfo }
     * 
     */
    public CdConditionInfo createCdConditionInfo() {
        return new CdConditionInfo();
    }

    /**
     * Create an instance of {@link DependentCollection }
     * 
     */
    public DependentCollection createDependentCollection() {
        return new DependentCollection();
    }

    /**
     * Create an instance of {@link BaseAddressInfo }
     * 
     */
    public BaseAddressInfo createBaseAddressInfo() {
        return new BaseAddressInfo();
    }

    /**
     * Create an instance of {@link DependentFinancialsCollection }
     * 
     */
    public DependentFinancialsCollection createDependentFinancialsCollection() {
        return new DependentFinancialsCollection();
    }

    /**
     * Create an instance of {@link ConflictExperienceInfo }
     * 
     */
    public ConflictExperienceInfo createConflictExperienceInfo() {
        return new ConflictExperienceInfo();
    }

    /**
     * Create an instance of {@link MilitarySexualTraumaInfo }
     * 
     */
    public MilitarySexualTraumaInfo createMilitarySexualTraumaInfo() {
        return new MilitarySexualTraumaInfo();
    }

    /**
     * Create an instance of {@link RelationCollection }
     * 
     */
    public RelationCollection createRelationCollection() {
        return new RelationCollection();
    }

    /**
     * Create an instance of {@link PreferredFacilityInfo }
     * 
     */
    public PreferredFacilityInfo createPreferredFacilityInfo() {
        return new PreferredFacilityInfo();
    }

    /**
     * Create an instance of {@link CategoryCollection }
     * 
     */
    public CategoryCollection createCategoryCollection() {
        return new CategoryCollection();
    }

    /**
     * Create an instance of {@link ContactInfo }
     * 
     */
    public ContactInfo createContactInfo() {
        return new ContactInfo();
    }

    /**
     * Create an instance of {@link VamcDataCollection }
     * 
     */
    public VamcDataCollection createVamcDataCollection() {
        return new VamcDataCollection();
    }

    /**
     * Create an instance of {@link DemographicInfo }
     * 
     */
    public DemographicInfo createDemographicInfo() {
        return new DemographicInfo();
    }

    /**
     * Create an instance of {@link MilitaryServiceEpisodeInfo }
     * 
     */
    public MilitaryServiceEpisodeInfo createMilitaryServiceEpisodeInfo() {
        return new MilitaryServiceEpisodeInfo();
    }

    /**
     * Create an instance of {@link NonPrimaryFinancialStatementCollection }
     * 
     */
    public NonPrimaryFinancialStatementCollection createNonPrimaryFinancialStatementCollection() {
        return new NonPrimaryFinancialStatementCollection();
    }

    /**
     * Create an instance of {@link InsuranceCollection }
     * 
     */
    public InsuranceCollection createInsuranceCollection() {
        return new InsuranceCollection();
    }

    /**
     * Create an instance of {@link EnrollmentDeterminationInfo }
     * 
     */
    public EnrollmentDeterminationInfo createEnrollmentDeterminationInfo() {
        return new EnrollmentDeterminationInfo();
    }

    /**
     * Create an instance of {@link PhoneInfo }
     * 
     */
    public PhoneInfo createPhoneInfo() {
        return new PhoneInfo();
    }

    /**
     * Create an instance of {@link RatedDisabilityInfo }
     * 
     */
    public RatedDisabilityInfo createRatedDisabilityInfo() {
        return new RatedDisabilityInfo();
    }

    /**
     * Create an instance of {@link RelationInfo }
     * 
     */
    public RelationInfo createRelationInfo() {
        return new RelationInfo();
    }

    /**
     * Create an instance of {@link HardshipInfo }
     * 
     */
    public HardshipInfo createHardshipInfo() {
        return new HardshipInfo();
    }

    /**
     * Create an instance of {@link FinancialsInfo }
     * 
     */
    public FinancialsInfo createFinancialsInfo() {
        return new FinancialsInfo();
    }

    /**
     * Create an instance of {@link MilitaryServiceEpisodeCollection }
     * 
     */
    public MilitaryServiceEpisodeCollection createMilitaryServiceEpisodeCollection() {
        return new MilitaryServiceEpisodeCollection();
    }

    /**
     * Create an instance of {@link AddressCollection }
     * 
     */
    public AddressCollection createAddressCollection() {
        return new AddressCollection();
    }

    /**
     * Create an instance of {@link IneligibilityFactorInfo }
     * 
     */
    public IneligibilityFactorInfo createIneligibilityFactorInfo() {
        return new IneligibilityFactorInfo();
    }

    /**
     * Create an instance of {@link RatedDisabilityCollection }
     * 
     */
    public RatedDisabilityCollection createRatedDisabilityCollection() {
        return new RatedDisabilityCollection();
    }

    /**
     * Create an instance of {@link SensitivityInfo }
     * 
     */
    public SensitivityInfo createSensitivityInfo() {
        return new SensitivityInfo();
    }

    /**
     * Create an instance of {@link CdProcedureCollection }
     * 
     */
    public CdProcedureCollection createCdProcedureCollection() {
        return new CdProcedureCollection();
    }

    /**
     * Create an instance of {@link EligibilityCollection }
     * 
     */
    public EligibilityCollection createEligibilityCollection() {
        return new EligibilityCollection();
    }

    /**
     * Create an instance of {@link CategoryInfo }
     * 
     */
    public CategoryInfo createCategoryInfo() {
        return new CategoryInfo();
    }

    /**
     * Create an instance of {@link MilitaryServiceInfo }
     * 
     */
    public MilitaryServiceInfo createMilitaryServiceInfo() {
        return new MilitaryServiceInfo();
    }

    /**
     * Create an instance of {@link PowEpisodeCollection }
     * 
     */
    public PowEpisodeCollection createPowEpisodeCollection() {
        return new PowEpisodeCollection();
    }

    /**
     * Create an instance of {@link IncomeCollection }
     * 
     */
    public IncomeCollection createIncomeCollection() {
        return new IncomeCollection();
    }

    /**
     * Create an instance of {@link EeSummary }
     * 
     */
    public EeSummary createEeSummary() {
        return new EeSummary();
    }

    /**
     * Create an instance of {@link Eds }
     * 
     */
    public Eds createEds() {
        return new Eds();
    }

    /**
     * Create an instance of {@link SsnCollection }
     * 
     */
    public SsnCollection createSsnCollection() {
        return new SsnCollection();
    }

    /**
     * Create an instance of {@link PrisonerOfWarInfo }
     * 
     */
    public PrisonerOfWarInfo createPrisonerOfWarInfo() {
        return new PrisonerOfWarInfo();
    }

    /**
     * Create an instance of {@link DeathRecondInfo }
     * 
     */
    public DeathRecondInfo createDeathRecondInfo() {
        return new DeathRecondInfo();
    }

    /**
     * Create an instance of {@link IncompetenceRulingInfo }
     * 
     */
    public IncompetenceRulingInfo createIncompetenceRulingInfo() {
        return new IncompetenceRulingInfo();
    }

    /**
     * Create an instance of {@link HealthBenefitPlanCollection }
     * 
     */
    public HealthBenefitPlanCollection createHealthBenefitPlanCollection() {
        return new HealthBenefitPlanCollection();
    }

    /**
     * Create an instance of {@link VceEligibilityCollection }
     * 
     */
    public VceEligibilityCollection createVceEligibilityCollection() {
        return new VceEligibilityCollection();
    }

    /**
     * Create an instance of {@link NonPrimaryFinancialStatementInfo }
     * 
     */
    public NonPrimaryFinancialStatementInfo createNonPrimaryFinancialStatementInfo() {
        return new NonPrimaryFinancialStatementInfo();
    }

    /**
     * Create an instance of {@link CdProcedureInfo }
     * 
     */
    public CdProcedureInfo createCdProcedureInfo() {
        return new CdProcedureInfo();
    }

    /**
     * Create an instance of {@link IncomeTestInfo }
     * 
     */
    public IncomeTestInfo createIncomeTestInfo() {
        return new IncomeTestInfo();
    }

    /**
     * Create an instance of {@link PersonInfo }
     * 
     */
    public PersonInfo createPersonInfo() {
        return new PersonInfo();
    }

    /**
     * Create an instance of {@link PhoneCollection }
     * 
     */
    public PhoneCollection createPhoneCollection() {
        return new PhoneCollection();
    }

    /**
     * Create an instance of {@link IncomeInfo }
     * 
     */
    public IncomeInfo createIncomeInfo() {
        return new IncomeInfo();
    }

    /**
     * Create an instance of {@link MonetaryBenefitCollection }
     * 
     */
    public MonetaryBenefitCollection createMonetaryBenefitCollection() {
        return new MonetaryBenefitCollection();
    }

    /**
     * Create an instance of {@link DebitInfo }
     * 
     */
    public DebitInfo createDebitInfo() {
        return new DebitInfo();
    }

    /**
     * Create an instance of {@link FeeBasisCollection }
     * 
     */
    public FeeBasisCollection createFeeBasisCollection() {
        return new FeeBasisCollection();
    }

    /**
     * Create an instance of {@link AssetInfo }
     * 
     */
    public AssetInfo createAssetInfo() {
        return new AssetInfo();
    }

    /**
     * Create an instance of {@link MilitaryServiceSiteRecordCollection }
     * 
     */
    public MilitaryServiceSiteRecordCollection createMilitaryServiceSiteRecordCollection() {
        return new MilitaryServiceSiteRecordCollection();
    }

    /**
     * Create an instance of {@link EligibilityVerificationInfo }
     * 
     */
    public EligibilityVerificationInfo createEligibilityVerificationInfo() {
        return new EligibilityVerificationInfo();
    }

    /**
     * Create an instance of {@link VceEligibilityInfo }
     * 
     */
    public VceEligibilityInfo createVceEligibilityInfo() {
        return new VceEligibilityInfo();
    }

    /**
     * Create an instance of {@link BeneficiaryTravelCollection }
     * 
     */
    public BeneficiaryTravelCollection createBeneficiaryTravelCollection() {
        return new BeneficiaryTravelCollection();
    }

    /**
     * Create an instance of {@link AssetCollection }
     * 
     */
    public AssetCollection createAssetCollection() {
        return new AssetCollection();
    }

    /**
     * Create an instance of {@link MoveNotificationInfo }
     * 
     */
    public MoveNotificationInfo createMoveNotificationInfo() {
        return new MoveNotificationInfo();
    }

    /**
     * Create an instance of {@link SpouseFinancialsCollection }
     * 
     */
    public SpouseFinancialsCollection createSpouseFinancialsCollection() {
        return new SpouseFinancialsCollection();
    }

    /**
     * Create an instance of {@link DependentInfo }
     * 
     */
    public DependentInfo createDependentInfo() {
        return new DependentInfo();
    }

    /**
     * Create an instance of {@link IvmLetterStatusCollection }
     * 
     */
    public IvmLetterStatusCollection createIvmLetterStatusCollection() {
        return new IvmLetterStatusCollection();
    }

    /**
     * Create an instance of {@link DeliveryPreferences }
     * 
     */
    public DeliveryPreferences createDeliveryPreferences() {
        return new DeliveryPreferences();
    }

    /**
     * Create an instance of {@link LinkNotificationInfo }
     * 
     */
    public LinkNotificationInfo createLinkNotificationInfo() {
        return new LinkNotificationInfo();
    }

    /**
     * Create an instance of {@link AssociationInfo }
     * 
     */
    public AssociationInfo createAssociationInfo() {
        return new AssociationInfo();
    }

    /**
     * Create an instance of {@link PurpleHeartInfo }
     * 
     */
    public PurpleHeartInfo createPurpleHeartInfo() {
        return new PurpleHeartInfo();
    }

    /**
     * Create an instance of {@link CombatEpisodeCollection }
     * 
     */
    public CombatEpisodeCollection createCombatEpisodeCollection() {
        return new CombatEpisodeCollection();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeliveryPreferenceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "getDeliveryPreferenceRequest")
    public JAXBElement<GetDeliveryPreferenceRequest> createGetDeliveryPreferenceRequest(GetDeliveryPreferenceRequest value) {
        return new JAXBElement<GetDeliveryPreferenceRequest>(_GetDeliveryPreferenceRequest_QNAME, GetDeliveryPreferenceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEligibilityDeterminationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "getEligibilityDeterminationRequest")
    public JAXBElement<GetEligibilityDeterminationRequest> createGetEligibilityDeterminationRequest(GetEligibilityDeterminationRequest value) {
        return new JAXBElement<GetEligibilityDeterminationRequest>(_GetEligibilityDeterminationRequest_QNAME, GetEligibilityDeterminationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeliveryPreferenceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "getDeliveryPreferenceResponse")
    public JAXBElement<GetDeliveryPreferenceResponse> createGetDeliveryPreferenceResponse(GetDeliveryPreferenceResponse value) {
        return new JAXBElement<GetDeliveryPreferenceResponse>(_GetDeliveryPreferenceResponse_QNAME, GetDeliveryPreferenceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEligibilityDeterminationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "getEligibilityDeterminationResponse")
    public JAXBElement<GetEligibilityDeterminationResponse> createGetEligibilityDeterminationResponse(GetEligibilityDeterminationResponse value) {
        return new JAXBElement<GetEligibilityDeterminationResponse>(_GetEligibilityDeterminationResponse_QNAME, GetEligibilityDeterminationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEESummaryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "getEESummaryRequest")
    public JAXBElement<GetEESummaryRequest> createGetEESummaryRequest(GetEESummaryRequest value) {
        return new JAXBElement<GetEESummaryRequest>(_GetEESummaryRequest_QNAME, GetEESummaryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEESummaryHistoryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "getEESummaryHistoryRequest")
    public JAXBElement<GetEESummaryHistoryRequest> createGetEESummaryHistoryRequest(GetEESummaryHistoryRequest value) {
        return new JAXBElement<GetEESummaryHistoryRequest>(_GetEESummaryHistoryRequest_QNAME, GetEESummaryHistoryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDeliveryPreferenceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "updateDeliveryPreferenceRequest")
    public JAXBElement<UpdateDeliveryPreferenceRequest> createUpdateDeliveryPreferenceRequest(UpdateDeliveryPreferenceRequest value) {
        return new JAXBElement<UpdateDeliveryPreferenceRequest>(_UpdateDeliveryPreferenceRequest_QNAME, UpdateDeliveryPreferenceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDeliveryPreferenceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "updateDeliveryPreferenceResponse")
    public JAXBElement<UpdateDeliveryPreferenceResponse> createUpdateDeliveryPreferenceResponse(UpdateDeliveryPreferenceResponse value) {
        return new JAXBElement<UpdateDeliveryPreferenceResponse>(_UpdateDeliveryPreferenceResponse_QNAME, UpdateDeliveryPreferenceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIVMLetterStatusesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "getIVMLetterStatusesRequest")
    public JAXBElement<GetIVMLetterStatusesRequest> createGetIVMLetterStatusesRequest(GetIVMLetterStatusesRequest value) {
        return new JAXBElement<GetIVMLetterStatusesRequest>(_GetIVMLetterStatusesRequest_QNAME, GetIVMLetterStatusesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEESummaryHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "getEESummaryHistoryResponse")
    public JAXBElement<GetEESummaryHistoryResponse> createGetEESummaryHistoryResponse(GetEESummaryHistoryResponse value) {
        return new JAXBElement<GetEESummaryHistoryResponse>(_GetEESummaryHistoryResponse_QNAME, GetEESummaryHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonNotificationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "getPersonNotificationRequest")
    public JAXBElement<GetPersonNotificationRequest> createGetPersonNotificationRequest(GetPersonNotificationRequest value) {
        return new JAXBElement<GetPersonNotificationRequest>(_GetPersonNotificationRequest_QNAME, GetPersonNotificationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonNotificationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "getPersonNotificationResponse")
    public JAXBElement<GetPersonNotificationResponse> createGetPersonNotificationResponse(GetPersonNotificationResponse value) {
        return new JAXBElement<GetPersonNotificationResponse>(_GetPersonNotificationResponse_QNAME, GetPersonNotificationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEESummaryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.webservices.esr.med.va.gov/schemas", name = "getEESummaryResponse")
    public JAXBElement<GetEESummaryResponse> createGetEESummaryResponse(GetEESummaryResponse value) {
        return new JAXBElement<GetEESummaryResponse>(_GetEESummaryResponse_QNAME, GetEESummaryResponse.class, null, value);
    }

}
