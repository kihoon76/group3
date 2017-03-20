<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:importAttribute name="cssList" />
<tiles:importAttribute name="jsList"/>
<head>
	<meta charset="UTF-8">
	<title><tiles:getAsString name="title" ignore="true" /></title>
	<c:forEach var="cssItem" items="${cssList}">
	<link rel="stylesheet" href="<c:out value='${cssItem}' />" />
	</c:forEach>
	<c:forEach var="jsItem" items="${jsList}">
	<script type="text/javascript" src="<c:out value='${jsItem}'/>"></script>
	</c:forEach>
</head>
