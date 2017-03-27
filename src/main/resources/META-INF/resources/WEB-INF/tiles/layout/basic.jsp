<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<tiles:insertAttribute name="head" />
<body>
<h1>프로젝트 테스트 화면입니다.</h1>
	<tiles:insertAttribute name="topbar" />
	<tiles:insertAttribute name="body" />
</body>
</html>