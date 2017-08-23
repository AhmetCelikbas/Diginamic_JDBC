<#if ERROR??>
	<big><big>${ERROR}</big></big><br /><br /><br />
</#if>
<html>
	  <head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <title>TP1 Simple</title>
	
	    <!-- Bootstrap -->
			<!-- Latest compiled and minified CSS BOOTSTRAP -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		
	
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	  </head>
	  <body style="padding:20px;">
		<h2>Liste des agences :</h2>
		<#if liste_agences??>
			<table class="table table-hover">
		   		<thead>
			      <tr>
			        <th>idAgence</th>
			        <th>nom</th>
			        <th>adresse</th>
			      </tr>
			    </thead>
		   		<tbody>
					<#list liste_agences as agence>
						<tr>
						   	<td>${agence.idAgence}</td>
						   	<td>${agence.nom}</td>
						   	<td>${agence.adresse}</td>
					   	<tr>
					</#list>
				</tbody>
			</table>
		<#else>
			aucun résultat.
		</#if>
		
		
		<br /><br /><br />
		<h2>Information d'une agence :</h2>
		<#if agence_orpi??>
			<table class="table table-hover">
		   		<thead>
			      <tr>
			        <th>idAgence</th>
			        <th>nom</th>
			        <th>adresse</th>
			      </tr>
			    </thead>
		   		<tbody>
					<tr>
					   	<td>${agence_orpi.idAgence}</td>
					   	<td>${agence_orpi.nom}</td>
					   	<td>${agence_orpi.adresse}</td>
				   	<tr>
				 </tbody>
			</table>
		<#else>
			aucun résultat.
		</#if>
	
	

	    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	    <!-- Include all compiled plugins (below), or include individual files as needed -->
	    <script src="js/bootstrap.min.js"></script>
	  </body>
</html>