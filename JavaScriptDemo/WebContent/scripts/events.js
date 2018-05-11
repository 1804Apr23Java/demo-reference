/**
 * 
 */

window.onload = function(){
	
	document.getElementById("divWithText").addEventListener("mousemove",trackMouse); //last param is optional
	
	function trackMouse(event){
		console.log(event.timeStamp);
		document.getElementById("mouseX").innerHTML = event.clientX;
		document.getElementById("mouseY").innerHTML = event.clientY;
	}
	
	var myEventHandler = function(event) {
		console.log("target: "+event.target.id+" this: "+this.id);
	}
	
	var displayDivs = document.getElementsByClassName("displayDiv");
	for (var i=0; i<displayDivs.length; i++){
		displayDivs[i].addEventListener("click",myEventHandler);
	}
	
	//how to cancel events 
	function stopPropAndRoll(event){
		event.stopPropagation(); 
	}
	
	document.getElementById("div5").addEventListener("click",stopPropAndRoll);
}