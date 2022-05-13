<%--
- list.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.artifact.list.label.artifact_type" path="artifactType"/>	
	<acme:list-column code="inventor.artifact.list.label.name" path="name"/>
	<acme:list-column code="inventor.artifact.list.label.technology" path="technology"/>
	<acme:list-column code="inventor.artifact.list.label.description" path="description"/>
</acme:list>
<acme:button code="inventor.artifact.list.button.create" action="/inventor/artifact/create"/>		