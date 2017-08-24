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
                <li class="nav-item"><a id="createUser" class="nav-link" href="/">Lister</a></li>
                <li class="nav-item active"><a class="nav-link" href="/creerUtilisateur">Créer un utilisateur <span class="sr-only">(current)</span></a></li>
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
			<a  href="/" class="btn btn-secondary">Fermer</a>
		<#else>  
	      	<h1>Créer un utilisateur</h1>
			<form action="/validerCreationUtilisateur" method="post">
		    		<div class="form-group">
		    			<label for="exampleInputEmail1">Adresse mail</label>
		    			<input type="email" name="email" class="form-control" id="email" required aria-describedby="emailHelp" placeholder="Saisir l'adresse mail">
		  		</div>
		  		<div class="form-group">
		    			<label for="exampleInputPassword1">Mot de passe</label>
		    			<input type="password" name="password" class="form-control" required id="password" placeholder="Saisir le mot de passe">
		  		</div>
		    
		   		<div class="form-group row">
		      		<div class="col-sm-10">
		      			<a  href="/" class="btn btn-secondary">Retour</a>
		        			<button type="submit" class="btn btn-primary">Créer</button>
		      		</div>
		   		 </div>
		  	</form>
	  	</#if>
      </div>



  
  </body>
</html>