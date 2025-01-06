<%@page import="java.util.Map"%>
<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/components/header.jsp" %>
<%@include file="/components/bodyprimeraparte.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Odontologos</h1>
    <p class="mb-4">A continuación podrá visualizar la lista completa de odontologos registrados en el sistema.</p>

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
                            <th>Cedula</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                            <th>F/Nacimiento</th>
                            <th>Especialidad</th>
                            <th>Usuario</th>
                            <th>Horario</th>
                            <th style="width: 210px">Accion</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Cedula</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                            <th>F/Nacimiento</th>
                            <th>Especialidad</th>
                            <th>Usuario</th>
                            <th>Horario</th>
                            <th style="width: 210px">Accion</th>
                        </tr>
                    </tfoot>
                    
                    <% 
                    List<Odontologo> listaOdontologos = (List)request.getSession().getAttribute("listaOdontologos");
                    Map<Integer, String> fechasFormateadas = (Map<Integer, String>) request.getSession().getAttribute("fechasFormateadas");
                    if ( listaOdontologos == null || listaOdontologos.isEmpty()) {
                    %>
                    <p>No hay odontólogos registrados.</p>
                    <%
                    } else {
                        
                    %>

                    <tbody>
                        
                        <% for (Odontologo odonto : listaOdontologos){ %>
                        
                        <tr>
                            
                            <td id="id_odonto<%=odonto.getId() %>"> <%=odonto.getId() %> </td>
                            <td> <%=odonto.getCedula() %> </td>
                            <td><%=odonto.getNombre() %></td>
                            <td><%=odonto.getApellido() %></td>
                            <td><%=odonto.getTelefono() %></td>
                            <td><%=odonto.getDireccion() %></td>
                            <td><%=fechasFormateadas.get(odonto.getId()) %></td>
                            <td><%=odonto.getEspecialista() %></td>
                            <td><%=odonto.getUnUsuario().getNombreUsuario() %></td>
                            <td>
                                <%= (odonto.getUnHorario() != null) 
                                    ? odonto.getUnHorario().getHorario_inicio() + " - " + odonto.getUnHorario().getHorario_fin() 
                                    : "Horario no asignado" %>
                            </td>

                            <td style="display: flex; width: 230px"> 
                                <form name="eliminar" action="SvElimOdontologos" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px">
                                        <i class="fas fa-trash-alt">Eliminar</i>
                                    </button>
                                    <input type="hidden" name="id" value="<%=odonto.getId() %>">
                                </form>
                                
                                <form name="editar" action="SvEditOdontologos" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left:  5px">
                                        <i class="fas fa-pencil-alt">Editar</i>
                                    </button>
                                    <input type="hidden" name="id" value="<%=odonto.getId() %>">
                                </form>
                            </td>

                            
                        </tr>
                        
                        <% } %>
                        
                    </tbody>
                    
                    
                    <%
                    }
                    %>
                    
                              
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

<%@include file="/components/bodyfinal.jsp" %>
