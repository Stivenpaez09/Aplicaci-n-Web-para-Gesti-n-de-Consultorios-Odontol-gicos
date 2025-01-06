<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/components/header.jsp" %>
<%@include file="/components/bodyprimeraparte.jsp" %>
<h1>Crear Responsables</h1>
<p>Este es el apartado para crear los responsables de los pacientes de la clinica odontologica</p>

<form class="user" action="SvResponsables" method="POST">
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
            <input type="text" class="form-control form-control-user" id="responsable" name="tipo_resp"
                   placeholder="Tipo de responsable">
        </div>
    </div>
    
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Crear Responsable
    </button>
    <hr>
</form>



<%@include file="/components/bodyfinal.jsp" %>
