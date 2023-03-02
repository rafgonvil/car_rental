<#if ejb3>
<#if pojo.hasIdentifierProperty()>
<#if property.equals(clazz.identifierProperty)>
 ${pojo.generateAnnIdGenerator()}
<#-- if this is the id property (getter)-->
<#-- explicitly set the column name for this property-->
</#if>
</#if>

<#if c2h.isOneToOne(property)>
	<#if pojo.getDecoratedObject().getEntityName() == "com.indra.mob.model.collection.ColPayment" && property.name == "colPaymentCustomerSnapshot">
		@OneToOne(fetch = FetchType.EAGER, mappedBy = "colPayment")
	<#else>
		@OneToOne(fetch = FetchType.EAGER)
		<#--${pojo.generateOneToOneAnnotation(property, md)}-->
		${pojo.generateJoinColumnsAnnotation(property, md)}
	</#if>
	
<#elseif c2h.isManyToOne(property)>
<#-- @ManyToOne(fetch = FetchType.EAGER)-->
${pojo.generateManyToOneAnnotation(property)}
<#--TODO support optional and targetEntity-->    
${pojo.generateJoinColumnsAnnotation(property, md)}
<#elseif c2h.isCollection(property)>	
		${pojo.generateCollectionAnnotation(property, md)}
	
<#else>
${pojo.generateBasicAnnotation(property)}
${pojo.generateAnnColumnAnnotation(property)}
</#if>
</#if>