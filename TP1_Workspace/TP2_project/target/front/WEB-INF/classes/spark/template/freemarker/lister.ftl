<!DOCTYPE html>
<html lang="fr">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>JPA-TP3</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
  
    <style>
      body {
        padding-top: 5rem;
      }
      .container {
        padding: 1rem 1rem;
      }
    </style>
  </head>
  <body>
    <!-- jQuery first, then Tether, then Bootstrap JS. -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
  
		<script>
		$("#container").on('click-row.bs.table', function (e, row, $element) {
		    window.location = $element.data('href');
		});
	</script>


    <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#">JPA-TP3</a>
  
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"><a id="createUser" class="nav-link" href="#">Lister <span class="sr-only">(current)</span></a></li>
                <li class="nav-item"><a class="nav-link" href="/creerUtilisateur">Créer un utilisateur</a></li>
              </ul>
              <!--<form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Nom d'utilisateur">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
              </form>-->
        </div>
      </nav>

      <div class="container">
      	<#if ERROR??>
			<big><big>${ERROR}</big></big><br /><br /><br />
			<a  href="/" class="btn btn-secondary">Recharger la page</a>
		<#else> 
	      	<h1>Lister les utilisateurs</h1>
	      	<p>Cliquer sur un utilisateur pour le modifier.</p>
	      	<#if utilisateurs??>
		        <table class="table table-hover">
			   		<thead>
				      <tr>
				        <th>id</th>
				        <th>email</th>
				        <th>password</th>
				        <th> </th>
				      </tr>
				    </thead>
			   		<tbody>
						<#list utilisateurs as utilisateur>
							<tr onclick="window.location.href='/modifierUtilisateur/${utilisateur.idUser}'" style="cursor: pointer">
							   	<td>${utilisateur.idUser}</td>
							   	<td>${utilisateur.email}</td>
							   	<td>${utilisateur.password}</td>
							   	<td width="100px"><a href="/validerSupprimerUtilisateur/${utilisateur.idUser}" class="btn btn-danger btn-sm">Supprimer</a></td>
						   	<tr>
						</#list>
					</tbody>
				</table>
	      	<#else>
				Aucun résultat.
			</#if>
		</#if>
      </div>



  
  </body>
</html>