<%@page import="logica.Responsable"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/components/header.jsp" %>
<%@include file="/components/bodyprimeraparte.jsp" %>
<h1>Crear Pacientes</h1>
<p>Este es el apartado para crear los pacientes de la clinica odontologica</p>

<form class="user" action="SvPacientes" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="cedula" name="cedula"
                   placeholder="Cédula">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                   placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                   placeholder="Apellido">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                   placeholder="Teléfono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                   placeholder="Dirección">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="fecha_nac" name="fecha_nac"
                   placeholder="Fecha de Nacimiento">
        </div>
        <div class="col-sm-6 mb-3">
            <select class="form-control" id="tiene_seguro" name="tiene_seguro">
                <option value="true">Si</option>
                <option value="false">No</option>
            </select>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="tipoSangre" name="tipoSangre"
                   placeholder="Tipo de Sangre">
        </div>
        <div class="col-sm-6 mb-3">
            <select class="form-control " id="responsable" name="responsable">
                <% List<Responsable> responsables = (List) request.getSession().getAttribute("responsables");
                
                if (responsables != null && !responsables.isEmpty()) {
                    for(Responsable responsable : responsables){
                    %>
                    <option value="<%= responsable.getId()%>"><%= responsable.getId()%> <%= responsable.getNombre() %> <%=responsable.getApellido() %></option>
                    <%
                        }
                    
                } else {
                    
                    %>
                        <option value="">No hay responsables disponibles</option>
                    <% 
                    } 
                    %>
                    
            </select>
        </div>
    </div>
    
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Crear Usuario
    </button>
    <hr>
</form>



<%@include file="/components/bodyfinal.jsp" %>
