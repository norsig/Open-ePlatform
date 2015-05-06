package com.nordicpeak.flowengine.beans;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import se.unlogic.standardutils.annotations.WebPopulate;
import se.unlogic.standardutils.dao.annotations.DAOManaged;
import se.unlogic.standardutils.dao.annotations.Key;
import se.unlogic.standardutils.dao.annotations.ManyToOne;
import se.unlogic.standardutils.dao.annotations.OneToMany;
import se.unlogic.standardutils.dao.annotations.OrderBy;
import se.unlogic.standardutils.dao.annotations.Table;
import se.unlogic.standardutils.populators.EnumPopulator;
import se.unlogic.standardutils.populators.PositiveStringIntegerPopulator;
import se.unlogic.standardutils.populators.StringPopulator;
import se.unlogic.standardutils.reflection.ReflectionUtils;
import se.unlogic.standardutils.string.StringTag;
import se.unlogic.standardutils.validation.ValidationError;
import se.unlogic.standardutils.validation.ValidationException;
import se.unlogic.standardutils.xml.GeneratedElementable;
import se.unlogic.standardutils.xml.XMLElement;
import se.unlogic.standardutils.xml.XMLParser;
import se.unlogic.standardutils.xml.XMLParserPopulateable;
import se.unlogic.standardutils.xml.XMLValidationUtils;

import com.nordicpeak.flowengine.enums.ContentType;
import com.nordicpeak.flowengine.interfaces.ImmutableStatus;

@Table(name = "flowengine_flow_statuses")
@XMLElement
public class Status extends GeneratedElementable implements Serializable, ImmutableStatus, XMLParserPopulateable {

	private static final long serialVersionUID = -3364854013675598021L;

	public static final Field DEFAULT_STATUS_MAPPINGS_RELATION = ReflectionUtils.getField(Status.class, "defaultStatusMappings");
	public static final Field FLOW_RELATION = ReflectionUtils.getField(Status.class, "flow");
	public static final Field FLOW_INSTANCES_RELATION = ReflectionUtils.getField(Status.class, "flowInstances");

	@DAOManaged(autoGenerated = true)
	@Key
	@StringTag
	@XMLElement
	private Integer statusID;

	@DAOManaged
	@OrderBy
	@StringTag
	@WebPopulate(required = true, maxLength = 255)
	@XMLElement
	private String name;

	@DAOManaged
	@WebPopulate(maxLength = 65536)
	@XMLElement
	private String description;

	@DAOManaged
	@WebPopulate(populator = PositiveStringIntegerPopulator.class)
	@XMLElement
	private Integer managingTime;

	@DAOManaged
	@WebPopulate
	@XMLElement
	private boolean isUserMutable;

	@DAOManaged
	@WebPopulate
	@XMLElement
	private boolean isUserDeletable;

	@DAOManaged
	@WebPopulate
	@XMLElement
	private boolean isAdminMutable;

	@DAOManaged
	@WebPopulate
	@XMLElement
	private boolean isAdminDeletable;

	@DAOManaged
	@WebPopulate(required = true)
	@XMLElement
	private ContentType contentType;

	@DAOManaged(columnName = "flowID")
	@ManyToOne
	private Flow flow;

	@DAOManaged
	@OneToMany
	private List<FlowInstance> flowInstances;

	@DAOManaged
	@OneToMany
	@XMLElement(fixCase = true)
	private List<DefaultStatusMapping> defaultStatusMappings;

	@XMLElement
	private Integer flowInstanceCount;

	public Status() {}

	public Status(StandardStatus standardStatus) {

		this.name = standardStatus.getName();
		this.contentType = standardStatus.getContentType();
		this.isAdminDeletable = standardStatus.isAdminDeletable();
		this.isAdminMutable = standardStatus.isAdminMutable();
		this.isUserDeletable = standardStatus.isUserDeletable();
		this.isUserMutable = standardStatus.isUserMutable();
	}

	@Override
	public Integer getStatusID() {

		return statusID;
	}

	public void setStatusID(Integer statusID) {

		this.statusID = statusID;
	}

	@Override
	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Integer getManagingTime() {
		return managingTime;
	}

	public void setManagingTime(Integer managingTime) {
		this.managingTime = managingTime;
	}

	@Override
	public Flow getFlow() {

		return flow;
	}

	public void setFlow(Flow flow) {

		this.flow = flow;
	}

	@Override
	public List<FlowInstance> getFlowInstances() {

		return flowInstances;
	}

	public void setFlowInstances(List<FlowInstance> flowInstances) {

		this.flowInstances = flowInstances;
	}

	@Override
	public boolean isUserMutable() {

		return isUserMutable;
	}

	public void setUserMutable(boolean isUserMutable) {

		this.isUserMutable = isUserMutable;
	}

	@Override
	public boolean isAdminMutable() {

		return isAdminMutable;
	}

	public void setAdminMutable(boolean isAdminMutable) {

		this.isAdminMutable = isAdminMutable;
	}

	@Override
	public String toString() {

		return name + " (ID: " + statusID + ")";
	}

	@Override
	public List<DefaultStatusMapping> getDefaulStatusMappings() {

		return defaultStatusMappings;
	}

	public void setDefaultStatusMappings(List<DefaultStatusMapping> defaultFlowStateMappings) {

		this.defaultStatusMappings = defaultFlowStateMappings;
	}

	@Override
	public boolean isUserDeletable() {

		return isUserDeletable;
	}

	public void setUserDeletable(boolean isUserDeletable) {

		this.isUserDeletable = isUserDeletable;
	}

	@Override
	public ContentType getContentType() {

		return contentType;
	}

	public void setContentType(ContentType contentType) {

		this.contentType = contentType;
	}

	@Override
	public boolean isAdminDeletable() {

		return isAdminDeletable;
	}

	public void setAdminDeletable(boolean isAdminDeletable) {

		this.isAdminDeletable = isAdminDeletable;
	}

	public Integer getFlowInstanceCount() {

		return flowInstanceCount;
	}

	public void setFlowInstanceCount(Integer flowInstanceCount) {

		this.flowInstanceCount = flowInstanceCount;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((statusID == null) ? 0 : statusID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Status other = (Status) obj;
		if (statusID == null) {
			if (other.statusID != null) {
				return false;
			}
		} else if (!statusID.equals(other.statusID)) {
			return false;
		}
		return true;
	}

	@Override
	public void populate(XMLParser xmlParser) throws ValidationException {

		List<ValidationError> errors = new ArrayList<ValidationError>();

		this.statusID = XMLValidationUtils.validateParameter("statusID", xmlParser, true, PositiveStringIntegerPopulator.getPopulator(), errors);

		this.name = XMLValidationUtils.validateParameter("name", xmlParser, true, 1, 255, StringPopulator.getPopulator(), errors);
		this.description = XMLValidationUtils.validateParameter("description", xmlParser, false, 1, 65535, StringPopulator.getPopulator(), errors);
		this.managingTime = XMLValidationUtils.validateParameter("managingTime", xmlParser, false, PositiveStringIntegerPopulator.getPopulator(), errors);

		this.isUserMutable = xmlParser.getPrimitiveBoolean("isUserMutable");
		this.isUserDeletable = xmlParser.getPrimitiveBoolean("isUserDeletable");
		this.isAdminMutable = xmlParser.getPrimitiveBoolean("isAdminMutable");
		this.isAdminDeletable = xmlParser.getPrimitiveBoolean("isAdminDeletable");

		this.contentType = XMLValidationUtils.validateParameter("contentType", xmlParser, true, new EnumPopulator<ContentType>(ContentType.class), errors);

		if(!errors.isEmpty()){

			throw new ValidationException(errors);
		}

	}
}
