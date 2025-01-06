<%@page import="logica.Odontologo"%>
<%@page import="logica.Horario"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/components/header.jsp" %>
<%@include file="/components/bodyprimeraparte.jsp" %>
<h1>Crear Odontologos</h1>
<p>Esto es una prueba </p>

<% Odontologo odonto = (Odontologo) request.getSession().getAttribute("odonto"); 
String fecha = (String) request.getSession().getAttribute("fecha");
%>

<form class="user" action="SvEditOdontologos" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="cedula" name="cedula"
                   placeholder="cedula" value="<%=odonto.getCedula() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                   placeholder="Nombre" value="<%=odonto.getNombre() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                   placeholder="Apellido" value="<%=odonto.getApellido() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                   placeholder="Telefono" value="<%=odonto.getTelefono() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                   placeholder="Direccion" value="<%=odonto.getDireccion() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="fecha_nac" name="fecha_nac"
                   placeholder="Fecha de Nacimiento" value="<%=fecha %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="especialista" name="especialista"
                   placeholder="Especialidad" value="<%= odonto.getEspecialista() %>">
        </div>
        
        <div class="col-sm-6 mb-3">
            <select class="form-control " id="unUsuario" name="unUsuario">
                <% List<Usuario> usuarios = (List) request.getSession().getAttribute("listaUsuarios");
                
                if (usuarios != null && !usuarios.isEmpty()) {
                    for(Usuario usuario : usuarios){
                    %>
                    <option value="<%= usuario.getId_usuario()%>" <%= usuario.getId_usuario() == odonto.getUnUsuario().getId_usuario() ? "selected" : "" %>><%= usuario.getId_usuario() %> <%= usuario.getNombreUsuario() %> - <%= usuario.getRol() %></option>
                    <%
                        }
                    
                } else {
                    
                    %>
                        <option value="">No hay usuarios disponibles</option>
                    <% 
                    } 
                    %>
                    
            </select>
        </div> 
                    
        <div class="col-sm-6 mb-3">
            <select class="form-control " id="unHorario" name="unHorario">
                <% List<Horario> horarios = (List) request.getSession().getAttribute("listaHorarios");
                
                if (horarios != null && !horarios.isEmpty()) {
                    for(Horario horario : horarios){
                        boolean seleccionar = odonto.getUnHorario() != null && horario.getId_horario() == odonto.getUnHorario().getId_horario();
                    %>
                    <option value="<%= horario.getId_horario() %>" <%= seleccionar ? "selected" : "" %> > <%= horario.getHorario_inicio() %> - <%= horario.getHorario_fin() %></option>
                    <%
                    
                    }
                    
                } else {
                    
                    %>
                        <option value="">No hay horarios disponibles</option>
                    <% 
                    } 
                    %>
                    
            </select>
        </div>
                    
    </div>
    
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Editar Odontologo
    </button>
    <hr>
</form>


<%@include file="/components/bodyfinal.jsp" %>