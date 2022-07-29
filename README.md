<div>
<div># portfolio-fe</div>
<div>Proyecto final Argentina Programa: Portfolio</div>
<div>Franco Vico</div>
<br />
<div>Angular + Bootstrap</div>
<br />
<div>Endpoints:</div>
<br />
<div>AUTH</div>
<div>Post: Nuevo usuario: https://portfolio-be-francovico.herokuapp.com/auth/nuevo</div>
<div>Post: Login: https://portfolio-be-francovico.herokuapp.com/auth/login</div>
<br />
<div>PERSONA</div>
<div>Get: https://portfolio-be-francovico.herokuapp.com/traer - Traer lista de personas</div>
<div>Get: https://portfolio-be-francovico.herokuapp.com/traer/perfil - Traer persona asignada a perfil</div>
<div>Post: https://portfolio-be-francovico.herokuapp.com/crear - Crear persona</div>
<div>Delete: https://portfolio-be-francovico.herokuapp.com/delete/{id} - Borrar persona por Id</div>
<div>Put: https://portfolio-be-francovico.herokuapp.com/editar/{id} - Editar persona por Id</div>
<br />
<div>ABOUT / EXPERIENCE / EDUCATION / HASS:</div>
<div>(Cambiar about en url por experience, education, hass... mismos endpoints)</div>
<div>Get: https://portfolio-be-francovico.herokuapp.com/about/lista - Lista completa</div>
<div>Get: https://portfolio-be-francovico.herokuapp.com/about/lista/detail/${id} - Todos los campos por Id</div>
<div>Post: https://portfolio-be-francovico.herokuapp.com/about/create - Crear uno</div>
<div>Put: https://portfolio-be-francovico.herokuapp.com/about/update/${id} - Actualizar por Id</div>
<div>Delete: https://portfolio-be-francovico.herokuapp.com/about/delete/${id} - Borrar por Id</div>
</div>
<br />
<div>Falta securitizar los Endpoints Create/Delete/Update mediante la anotacion @PreAuthorize("hasRole('ROLE_ADMIN')") en los Endpoints. Esta todo implementado, pero debido a algun error que aun no pude encontrar al descomentarlo no permite la autenticación de ninguna manera. Entiendo la importancia de esto.</div>
