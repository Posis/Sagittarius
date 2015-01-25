---
title: Sagittarius Wizard
subtitle: Learn how to use the wizard to manage your application
template: tutorial.jade
---

# Running the Wizard


					<div class="alert alert-block">
						<h4>Warning!</h4>
						Currently the Sagittarius Wizard is available only in Python source form, not as an executable or application. To run it you will need either the <a href="http://www.pythonware.com/products/pil/">Python Imaging Library</a> (PIL) or its 64-bit alternative <a href="http://www.lfd.uci.edu/~gohlke/pythonlibs/#pillow">Pillow</a>.
					</div>

					<p>Navigate to the <code>Sagittarius-Wizard/</code> directory of your Sagittarius distribution and run the command <code>python SagittariusWizard.py</code> in your favorite command line.</p>
				</section>

				<section id="recipes">
					<div class="page-header">
						<h1>Recipes</h1>
					</div>

					<h2 id="what-are-recipes">What Are Recipes?</h2>
					<p>Using the wizard revolves around the idea of <span class="label label-important">RECIPES</span>. A recipe is a collection of buttons (you can think of them as &ldquo;ingredients&rdquo;), each with certain attributes, that does something when submitted to your application. The following buttons are available:</p>
					
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/filter.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Add Filter <span class="label">GET</span> <span class="label">MODIFY</span> <span class="label">DELETE</span></h4>
							Filters restrict which objects to return based on equality. For example, an <code>object_type=="motd"</code> filter would only return objects whose type is &ldquo;motd&rdquo;.
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/project.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Add Projection <span class="label">GET</span> <span class="label">MODIFY</span> <span class="label">DELETE</span></h4>
							Projections tell the database to return only the attributes of the object that are specified. If no projections are specified, the entire object is returned (at higher cost).
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/attribute.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Add Attribute <span class="label">ADD</span></h4>
							Specifies the value of an attribute for the object to be added to the database.
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/modification.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Modify Attribute <span class="label">MODIFY</span></h4>
							Specifies the new value of an attribute to be modified. If more than one object is being modified, all objects will take on this new value.
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/limit.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Set Limit <span class="label">GET</span> <span class="label">MODIFY</span> <span class="label">DELETE</span></h4>
							Sets the maximum number of objects to operate on. If more objects exist that satisfy your query, they will be ignored.
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/offset.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Set Offset <span class="label">GET</span> <span class="label">MODIFY</span> <span class="label">DELETE</span></h4>
							Sets the offset in the database to return results. This allows for pagination across multiple queries: query 1 can get objects 0-19, query 2 can get objects 20-39, and so on.
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/returns.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Returns Results <span class="label">MODIFY</span> <span class="label">DELETE</span></h4>
							By default, the MODIFY and DELETE actions do not return objects. This button tells the actions to return results, optionally with projections and limits as in a GET action.
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/generic.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Generic Parameter <span class="label">LEADERBOARDS</span> <span class="label">SEND MAIL</span></h4>
							Represents a generic URL parameter, and is used for more low-level interactions with the Sagittarius API. For example, a generic parameter with field &ldquo;f&rdquo; and value &ldquo;v&rdquo; will be encoded as <code>&amp;f=v</code>.
						</div>
					</div>
					<br>
					<p>In addition, there is a special <strong>action button</strong> automatically added to each recipe. To select the action you want your recipe to carry out, simply left-click the action button (it should be the first button in the <strong>Recipe</strong> row) and select the action from the drop-down list. The following actions are available:</p>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/dbget.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Get Action</h4>
							Get objects or parts of objects from the database. Which objects are returned, and how many to return, are based on the filters and limits you apply to this action.
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/dbadd.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Add Action</h4>
							Add an object with the specified attributes to the database.
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/dbmod.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Modify Action</h4>
							Modify certain attributes of objects from the database, optionally returning the modified objects. The objects to modify are determined by applied filters and limits.
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/dbdel.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Delete Action</h4>
							Delete all objects that satisfy the applied filters and limits from the database, optionally returning them.
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/ldbds.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Leaderboards Action</h4>
							Interact with the leaderboards system built into Sagittarius. Offers full support for adding/purging/removing leaderboards, posting to an existing leaderboard, and getting leaderboard data.
						</div>
					</div>
					<div class="media">
						<img class="media-object pull-left" src="img/wizard/mail.png" width="70">
						<div class="media-body">
							<h4 class="media-heading">Send Mail Action</h4>
							Send an email to the provided address through Sagittarius.
						</div>
					</div>

					<h2 id="an-example-recipe">An Example Recipe</h2>
					<p>Consider the recipe below:</p>
					<div>
						<div style="float:left; margin-right:10px; margin-bottom:10px;"><img class="media-object" src="img/wizard/dbget.png" width="70"></div>
						<div style="float:left; margin-right:10px; margin-bottom:10px;"><img class="media-object" src="img/wizard/filter.png" width="70"></div>
						<div style="float:left; margin-right:10px; margin-bottom:10px;"><img class="media-object" src="img/wizard/filter.png" width="70"></div>
						<div style="float:left; margin-right:10px; margin-bottom:10px;"><img class="media-object" src="img/wizard/project.png" width="70"></div>
						<div style="float:left; margin-right:10px; margin-bottom:10px;"><img class="media-object" src="img/wizard/limit.png" width="70"></div>
						<div style="clear:both;"></div>
					</div>
					<p>This is a simple recipe that queries for the current Message of the Day. The first button tells Sagittarius that it wants to GET data. The two filters make sure that all returned objects have <code>object_type==motd</code> and <code>object_name==motd</code>. Since we only want the actual message, we add a projection on the <code>message</code> attribute of our MOTD object. Finally, we only want one MOTD returned, so we set a limit of 1.</p>
					
					
					<h2 id="adding-and-deleting-buttons">Adding and Deleting Buttons</h2>
					<p>Add a button to your recipe by clicking on it in the <strong>Available Buttons</strong> row. Not all buttons in the row will be clickable; whether or not you can add a button depends on the action you have selected. Once you have added a button, you can click on it in the <strong>Recipe</strong> row to modify its attributes. Doing so will bring up a dialogue of available options for that button type.</p>
					<p>If you want to delete a button from your recipe, just right-click it. For a quick way to clear an entire recipe, go to <strong>File &rarr; Clear Recipe</strong> or press <strong>Ctrl+N</strong>. Note that you can never delete the action button.</p>

					<h2 id="managing-recipes">Managing Recipes</h2>
					<p>The best part about recipes is that you can save and load them at any time. To save a new recipe, go to <strong>File &rarr; Save Recipe As...</strong> or press <strong>Alt+S</strong> and enter the name you would like to give the recipe. You can also use the quicker <strong>File &rarr; Save Recipe</strong> or <strong>Ctrl+S</strong> (if the recipe has not already been saved, you will be prompted to name it).</p>
					<p>You can load a recipe by going to <strong>File &rarr; Load Recipe</strong> or pressing <strong>Ctrl+O</strong>. Choose the recipe you want to load from the dropdown list and press <strong>Load</strong> to load it.</p>
					<p>A saved recipe can be deleted by going to <strong>File &rarr; Delete Recipe</strong> (for safety reasons there is no shortcut command). This will NOT clear the recipe from the <strong>Recipe</strong> row, but it <i>will</i> remove it from the save file. Similarly, if you clear a loaded recipe you can still save it to file; the saved recipe will be empty.</p>
					<div class="alert alert-block alert-info">
						<h4>A Note on Saving</h4>
						The save file for the Sagittarius Wizard is a file called <code>recipes.dat</code> in the same directory as <code>SagittariusWizard.py</code>. Avoid modifying this file. Also, this file is not written to until the wizard is <i>closed</i>, meaning that if the wizard should crash or be process-interrupted, you will lose any changes you have made in the current session.
					</div>
				</section>

				<section id="global-options">
					<div class="page-header">
						<h1>Global Options</h1>
					</div>
					<p>Before submitting a recipe, you must fill out the App ID and Password fields in the <strong>Global Options</strong> row. These values are the same as the values of <code>[APP ID HERE]</code> and <code>[APP PASSWORD HERE]</code> from your application's <code>app.yaml</code> file. For more information, see <a href="getting-started.html#modifying-appyaml">here</a>.</p>
					<p>For convenience, these fields are saved every time you exit and will have their previous values the next time you run the wizard.</p>
				</section>

				<section id="understanding-the-output">
					<div class="page-header">
						<h1>Understanding the Output</h1>
					</div>
					<p class="lead">Coming soon!</p>
				</section>

			</div>
		</div>
	</div>

	<script>printFooter();</script>

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/holder.js"></script>
	<script src="js/prettify.js"></script>
	<script src="js/application.js"></script>
</body>
</html>
