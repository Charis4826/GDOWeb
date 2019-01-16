package herbalife.modules;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class MemberShip {
	private Addresses addresses;
	private String apfDueDate;
	private String birthDate;
	private String dsSubType;
	private String dsType;
	private List<Email> emails;
	private ErrorModel error;
	private Flags flags;
	private String memberId;
	private Names names;
	private List<String> phones;
	private String processingCountryCode;
	private String residenceCountryCode;
	private String sponsorId;
	private String teamLevel;
	private String tenCustomerFormStatus;
	private VolumeLimits volumeLimits;
	private String custCategoryType;

	public ErrorModel getError() {
		return error;
	}

	public void setError(ErrorModel error) {
		this.error = error;
	}

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Names getNames() {
		return names;
	}

	public void setNames(Names names) {
		this.names = names;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getApfDueDate() {
		return apfDueDate;
	}

	public void setApfDueDate(String apfDueDate) {
		this.apfDueDate = apfDueDate;
	}

	public String getDsType() {
		return dsType;
	}

	public void setDsType(String dsType) {
		this.dsType = dsType;
	}

	public String getDsSubType() {
		return dsSubType;
	}

	public void setDsSubType(String dsSubType) {
		this.dsSubType = dsSubType;
	}

	public String getTeamLevel() {
		return teamLevel;
	}

	public void setTeamLevel(String teamLevel) {
		this.teamLevel = teamLevel;
	}

	public String getTenCustomerFormStatus() {
		return tenCustomerFormStatus;
	}

	public void setTenCustomerFormStatus(String tenCustomerFormStatus) {
		this.tenCustomerFormStatus = tenCustomerFormStatus;
	}

	public String getProcessingCountryCode() {
		return processingCountryCode;
	}

	public void setProcessingCountryCode(String processingCountryCode) {
		this.processingCountryCode = processingCountryCode;
	}

	public String getResidenceCountryCode() {
		return residenceCountryCode;
	}

	public void setResidenceCountryCode(String residenceCountryCode) {
		this.residenceCountryCode = residenceCountryCode;
	}

	public Flags getFlags() {
		return flags;
	}

	public void setFlags(Flags flags) {
		this.flags = flags;
	}

	public VolumeLimits getVolumeLimits() {
		return volumeLimits;
	}

	public void setVolumeLimits(VolumeLimits volumeLimits) {
		this.volumeLimits = volumeLimits;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}

	public String getCustCategoryType() {
		return custCategoryType;
	}

	public void setCustCategoryType(String custCategoryType) {
		this.custCategoryType = custCategoryType;
	}
	
	/*public boolean isApfDue() {

		Date apfDue = NewDateUtil.newParseUTCDate(apfDueDate);

		int compare = Calendar.getInstance().getTime().compareTo(apfDue);

		return compare >= 0;
	}*/
}
