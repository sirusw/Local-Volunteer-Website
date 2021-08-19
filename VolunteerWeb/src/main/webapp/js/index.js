// Note: This example requires that you consent to location sharing when
// prompted by your browser. If you see the error "The Geolocation service
// failed.", it means you probably did not give permission for the browser to
// locate you.
let map, infoWindow;
let markers = [];
let eventMarkers = [];

function initMap() {

  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: 49.234950, lng: -122.776330 },
    zoom: 6,
  });
	
  initEventMarkers();

  initMarkerCluster();

  getLatLngFromClick();

  getGeolocation();
  
  
}

function initMarkerCluster(){
	new MarkerClusterer(map,eventMarkers, {
    imagePath:
      "https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m",
  });
}

function initEventMarkers(){
  var table = document.getElementById("volEvent");
  if(table!=null){
		for (var i = 0, row; row = table.rows[i]; i++) {
			   //iterate through rows
			   //rows would be accessed using the "row" variable assigned in the for loop
		   	var lat = row.cells[6].innerHTML;  //lat
			var lng = row.cells[7].innerHTML;  //lng
			const latlng = {
			    lat: parseFloat(lat),
			    lng: parseFloat(lng),
  			};
			addEventMarker(latlng, row);
		}
  }
}

function addEventMarker(position, row) {
  const marker = new google.maps.Marker({
    position,
    map,
  });
  var eid = row.cells[0].innerHTML;
  var title = row.cells[1].innerHTML;
  var description = row.cells[2].innerHTML;
  var organizer = row.cells[3].innerHTML;
  var tel = row.cells[4].innerHTML;
  var numPeople = row.cells[5].innerHTML;
  

  marker.addListener("click", () => {
		var info;
		var numPeopleCurr = 0;
		var full = false;
	  	infoWindow = new google.maps.InfoWindow({
      		position: marker.getPosition(),
       	});
		var uid = document.getElementById("uid").innerHTML;
		if(uid==null || uid==""){
			info = "<h5>Please <a style=\"outline:none; display:inline\" href=\"login\">login</a> before you sign up to an event</h5>";
		}
		else{
			var table = document.getElementById("volParticipated");
			var signedUp = false;
			var numPeopleTable = document.getElementById("numPeopleParticipated");
			
			if(numPeopleTable!=null){
					for (var i = 0, row; row = numPeopleTable.rows[i]; i++) {
						   //iterate through rows
						   //rows would be accessed using the "row" variable assigned in the for loop
					   	var eidNumPeople = row.cells[0].innerHTML;  
						var numPeopleParticipated = row.cells[1].innerHTML;  
						if(eidNumPeople == eid){
							numPeopleCurr = numPeopleParticipated;
						}
						
					}
					
			  }
			
			if(numPeopleCurr == numPeople){
				full = true;
			}
			
			
			if(table!=null){
				for (var i = 0, row; row = table.rows[i]; i++) {
				   //iterate through rows
				   //rows would be accessed using the "row" variable assigned in the for loop
				   	var eidParticipated = row.cells[1].innerHTML;
					if(eidParticipated == eid) {
						
						signedUp = true; break;
					}  
				}
 			}
		
			if(signedUp==true){
					info = "<p>Event ID: " + eid
					+ "<br>Event Name： " + title 
					+ "<br>Description: " + description 
					+ "<br>Organizer " + organizer 
					+ "<br>Tel: " + tel 
					+ "<br>People Needed: "+ numPeopleCurr +"/"+numPeople
					+ "</p><form action=\"undoSignup\" method = \"POST\">"
					+ "<input style=\"display:none\" type=\"number\" name=\"uid\" value=\""+uid+"\">"
					+ "<input style=\"display:none\" type=\"number\" name=\"eid\" value=\""+eid+"\">"
					+ "<input type=\"submit\" class=\"btn btn-active\" value=\"Cancel\"/>"; 
			}
				
			
			else if(full){
				info = "<p>Event ID: " + eid
				+ "<br>Event Name： " + title 
				+ "<br>Description: " + description 
				+ "<br>Organizer " + organizer 
				+ "<br>Tel: " + tel 
				+ "<br>People Needed: "+numPeopleCurr +"/"+numPeople
				+ "</p>"
				+ "<input style=\"display:none\" type=\"number\" name=\"uid\" value=\""+uid+"\">"
				+ "<input style=\"display:none\" type=\"number\" name=\"eid\" value=\""+eid+"\">"
				+ "<input type=\"button\" class=\"btn btn-disabled\" value=\"Full\"/>"; 
			}
			
			else{
				info = "<p>Event ID: " + eid
				+ "<br>Event Name： " + title 
				+ "<br>Description: " + description 
				+ "<br>Organizer " + organizer 
				+ "<br>Tel: " + tel 
				+ "<br>People Needed: "+numPeopleCurr +"/"+numPeople
				+ "</p><form action=\"regEvent\" method = \"POST\">"
				+ "<input style=\"display:none\" type=\"number\" name=\"uid\" value=\""+uid+"\">"
				+ "<input style=\"display:none\" type=\"number\" name=\"eid\" value=\""+eid+"\">"
				+ "<input type=\"Submit\" class=\"btn btn-primary\" value=\"Sign up\"/></form>"; 
			}
		}
		infoWindow.setContent(info);
    	infoWindow.open(map);
		
  });
  eventMarkers.push(marker);
}

function getGeolocation(){
  infoWindow = new google.maps.InfoWindow();
  const locationButton = document.createElement("button");
  locationButton.textContent = "Current Location";
  locationButton.classList.add("custom-map-control-button");
  map.controls[google.maps.ControlPosition.TOP_CENTER].push(locationButton);
  locationButton.addEventListener("click", () => {
    // Try HTML5 geolocation.
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        (position) => {
          const pos = {
            lat: position.coords.latitude,
            lng: position.coords.longitude,
          };
          //infoWindow.setPosition(pos);
          //infoWindow.setContent("Found.");
          //infoWindow.open(map);
          map.setCenter(pos);
		  map.setZoom(12);
        },

        () => {
          handleLocationError(true, infoWindow, map.getCenter());
        }
      );
    } else {
      // Browser doesn't support Geolocation
      handleLocationError(false, infoWindow, map.getCenter());
    }
  });
}

function drawCircle(pos){
	const cityCircle = new google.maps.Circle({
		  
	      strokeColor: "#FF0000",
	      strokeOpacity: 0.3,
	      strokeWeight: 2,
	      fillColor: "#FF0000",
	      fillOpacity: 0.1,
	      map,
	      center: pos,
	      radius: 10000 ,
    	});
}

function geocodeLatLng(str) {
  const geocoder = new google.maps.Geocoder();
  const latlngStr = str.split(",", 2);
  const latlng = {
    lat: parseFloat(latlngStr[0]),
    lng: parseFloat(latlngStr[1]),
  };
  geocoder
    .geocode({ location: latlng })
    .then((response) => {
      if (response.results[0]) {
		document.getElementById("address").setAttribute("value", response.results[0].formatted_address);
        document.getElementById("lat").setAttribute("value", latlngStr[0]);
		document.getElementById("lng").setAttribute("value", latlngStr[1]);
		addr = response.results[0].formatted_address;

      } else {
        window.alert("No results found");
      }
    })
    .catch((e) => window.alert(e));
}

function getLatLngFromClick(){
	
	
	// Configure the click listener.
  	map.addListener("click", (mapsMouseEvent) => {
    // Close the current InfoWindow.
	hideMarkers();
    infoWindow.close();
    // Create a new InfoWindow.
	geocodeLatLng(parseLatLng(mapsMouseEvent.latLng.toString()));
	
    infoWindow = new google.maps.InfoWindow({
      position: mapsMouseEvent.latLng,
    });
    //infoWindow.setContent(addr);
    //infoWindow.open(map);
	addMarker(mapsMouseEvent.latLng);
	
  });
}

function addMarker(position) {
  const marker = new google.maps.Marker({
    position,
    map,
  });
  
  markers.push(marker);
}



function hideMarkers() {
  setMapOnAll(null);
  markers = [];
}

function setMapOnAll(map) {
  for (let i = 0; i < markers.length; i++) {
    markers[i].setMap(map);
  }
}

function parseLatLng(latLng){
	latLng = latLng.substring(1, latLng.length -1);
	return latLng;
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
  infoWindow.setPosition(pos);
  infoWindow.setContent(
    browserHasGeolocation
      ? "Error: The Geolocation service failed."
      : "Error: Your browser doesn't support geolocation."
  );
  infoWindow.open(map);
}