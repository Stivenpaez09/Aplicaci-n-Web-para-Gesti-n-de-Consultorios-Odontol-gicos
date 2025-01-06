<%@page import="logica.Responsable"%>
<%@page import="java.util.List"%>
<%@page import="logica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/components/header.jsp" %>
<%@include file="/components/bodyprimeraparte.jsp" %>
<h1>Editar Pacientes</h1>
<p>Este es el apartado para editar un usuarios del sistema</p>

<% Paciente pac = (Paciente) request.getSession().getAttribute("paciente");%>
<% String fecha_nac = (String) request.getSession().getAttribute("fecha_nac");%>
<form class="user" action="SvEditPacientes" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="cedula" name="cedula"
                   placeholder="Cédula" value="<%=pac.getCedula() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                   placeholder="Nombre" value="<%=pac.getNombre() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                   placeholder="Apellido" value="<%=pac.getApellido() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                   placeholder="Teléfono" value="<%=pac.getTelefono() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                   placeholder="Dirección" value="<%=pac.getDireccion() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="fecha_nac" name="fecha_nac"
                   placeholder="Fecha de Nacimiento" value="<%=fecha_nac %>">
        </div>
        <div class="col-sm-6 mb-3">
            <select class="form-control" id="tiene_seguro" name="tiene_seguro">
                <option value="true" <%= pac.isTiene_seguro() ? "selected" : "" %>>Si</option>
                <option value="false" <%= !pac.isTiene_seguro() ? "selected" : "" %>>No</option>
            </select>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="tipoSangre" name="tipoSangre"
                   placeholder="Tipo de Sangre" value="<%=pac.getTipoSangre() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <select class="form-control" id="responsable" name="responsable">
                <% 
                List<Responsable> responsables = (List) request.getSession().getAttribute("listaResponsables");
                if (responsables != null && !responsables.isEmpty()) {
                    for (Responsable responsable : responsables) {
                %>
                <option value="<%= responsable.getId() %>" 
                    <%= responsable.getId() == pac.getUnResponsable().getId() ? "selected" : "" %>>
                    <%= responsable.getId() %> <%= responsable.getNombre() %> <%= responsable.getApellido() %>
                </option>
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
        Editar Paciente
    </button>
    <hr>
</form>


<%@include file="/components/bodyfinal.jsp" %>
