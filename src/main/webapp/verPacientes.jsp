<%@page import="java.util.Map"%>
<%@page import="logica.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/components/header.jsp" %>
<%@include file="/components/bodyprimeraparte.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Pacientes</h1>
    <p class="mb-4">A continuación podrá visualizar la lista completa de Pacientes registrados.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido </th>
                            <th>Cedula</th>
                            <th>Fecha Nacimiento</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                            <th>Tipo Sangre</th>
                            <th>Seguro (0/1)</th>
                            <th>Responsable</th>
                            <th>Acciones</th>
                            <th>N. Responsable</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido </th>
                            <th>Cedula</th>
                            <th>Fecha Nacimiento</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                            <th>Tipo Sangre</th>
                            <th>Seguro (0/1)</th>
                            <th>Responsable</th>
                            <th>Acciones</th>
                            <th>N. Responsable</th>
                        </tr>
                    </tfoot>
                    
                    <% 
                    List<Paciente> listaPacientes = (List)request.getSession().getAttribute("listaPacientes");
                    Map<Integer, String> fechasFormateadas = (Map<Integer, String>) session.getAttribute("fechasFormateadas");
                    %>
                    
                    <tbody>
                        <% for(Paciente pac: listaPacientes) { %>
                        <tr>
                            <td id="id_pac<%=pac.getId()%>"><%=pac.getId() %></td>
                            <td><%=pac.getNombre() %></td>
                            <td><%=pac.getApellido() %></td>
                            <td><%=pac.getCedula() %></td>
                            <td><%=fechasFormateadas.get(pac.getId()) %></td>
                            <td><%=pac.getTelefono() %></td>
                            <td><%=pac.getDireccion() %></td>
                            <td><%=pac.getTipoSangre() %></td>
                            <td><%=pac.isTiene_seguro() %></td>
                            <td><%=pac.getUnResponsable().getId() %></td>
                            <td><%=pac.getUnResponsable().getNombre() + pac.getUnResponsable().getApellido() %></td>                            
                            
                            
                            <td style="display: flex; width: 230px"> 
                                <form name="eliminar" action="SvElimPacientes" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px">
                                        <i class="fas fa-trash-alt">Eliminar</i>
                                    </button>
                                    <input type="hidden" name="id" value="<%=pac.getId() %>">
                                </form>
                                
                                <form name="editar" action="SvEditPacientes" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left:  5px">
                                        <i class="fas fa-pencil-alt">Editar</i>
                                    </button>
                                    <input type="hidden" name="id" value="<%=pac.getId() %>">
                                </form>
                            </td>
                            
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

<%@include file="/components/bodyfinal.jsp" %>