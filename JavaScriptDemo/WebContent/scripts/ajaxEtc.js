/**
 * 
 */

var toggle = setInterval(function() {

	console.log("called interval");
	setColor();

}, 3000);

function setColor() {
	var x = document.getElementById("toggleDiv");
	x.style.backgroundColor = x.style.backgroundColor == 'cyan' ? '#87fa4b'
			: 'cyan';
};

function stopColor() {
	clearInterval(toggle);
};

function getPokemon(xhr) {
	var res = JSON.parse(xhr.responseText);
	var html = "<h4>chosen pokemon has name: " + res.name + "</h4>";
	document.getElementById("pokeResult").innerHTML = html;
};

function sendAjaxGet(url, func) {
	// step 1: obtain xhr
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	// step 2: define onreadystatechange
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	// step 3: prepare request
	xhr.open("GET", url, true);
	// step 4: send request
	xhr.send();
};

window.onload = function() {
	toggle;
	document.getElementById("pokeButton").addEventListener(
			"click",
			function() {
				sendAjaxGet('https://pokeapi.co/api/v2/pokemon/'
						+ document.getElementById("pokeId").value, getPokemon);
			});
}