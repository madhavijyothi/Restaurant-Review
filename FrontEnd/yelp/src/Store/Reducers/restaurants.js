const initialState = [

	{ id: 1, name: "Ristorante Bindella", email: "bindella@ristorante.com", phone: "044 221 25 46", 
	web: "http://www.bindella.ch/de/bindella-zuerich.html", address: "In Gassen 6, 8001 Zürich", 
	reviews: [ 
		{ id: 1, content: "Freaking awesome!", rate: 5, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "21.06.2017"},
		{ id: 2, content: "Best service ever", rate: 4, user: { id: 2, firstName: "Robert", lastName: "Smith"}, created_at: "18.06.2017"},
		{ id: 3, content: "Freaking awesome!", rate: 5, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "21.06.2017"},
		{ id: 4, content: "Freaking awesome!", rate: 5, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "21.06.2017"},
		{ id: 5, content: "Freaking awesome!", rate: 5, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "21.06.2017"},
		{ id: 6, content: "Freaking awesome!", rate: 5, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "21.06.2017"},
		{ id: 7, content: "Freaking awesome!", rate: 5, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "21.06.2017"}
		]
	},

	{ id: 2, name: "Echo", email: "info@echorestaurant.ch", phone: "044 360 73 18", 
	web: "http://www.echorestaurant.ch/", address: "Neumühlequai 42, 8006 Zürich", 
	reviews: [ 
		{ id: 1, content: "Very nice restaurant", rate: 4, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "20.06.2017"},
		{ id: 2, content: "Good food, nice location", rate: 4, user: { id: 2, firstName: "Robert", lastName: "Smith"}, created_at: "19.06.2017"},
		{ id: 3, content: "Very nice restaurant", rate: 3, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "20.06.2017"},
		{ id: 4, content: "Very nice restaurant", rate: 5, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "20.06.2017"},
		{ id: 5, content: "Very bad", rate: 1, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "20.06.2017"},
		{ id: 6, content: "Very nice restaurant", rate: 4, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "20.06.2017"}
		]
	},

	{ id: 3, name: "Lilly Jo", email: "info@lillyjo.ch", phone: "043 543 63 51",
	web: "https://lillyjo.ch/", address: "Pfingstweidstrasse 16, 8005 Zürich",
	reviews: [
		{ id: 1, content: "good", rate: 4, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "20.06.2017"},
		{ id: 2, content: "nice location", rate: 1, user: { id: 2, firstName: "Robert", lastName: "Smith"}, created_at: "19.06.2017"}
		]
	},

	{ id: 4, name: "Hiltl", email: "info@hiltl.ch", phone: "044 227 70 00",
	web: "https://www.hiltl.ch/", address: "Sihlstrasse 28, 8001 Zürich",
	reviews: [
		{ id: 1, content: "best veg food", rate: 4, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "20.06.2017"},
		{ id: 2, content: "good for children", rate: 5, user: { id: 2, firstName: "Robert", lastName: "Smith"}, created_at: "19.06.2017"}
		]
	},

	{ id: 5, name: "Wurst und Moritz", email: "info@wurstundmoritz.com", phone: " 043 540 41 47",
	web: "http://wurstundmoritz-zuerich.ch/", address: "Hardstrasse 318, 8005 Zürich",
	reviews: [
		{ id: 1, content: "vegan curry wurst", rate: 2, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "20.06.2017"},
		{ id: 2, content: "best fries in town", rate: 1, user: { id: 2, firstName: "Robert", lastName: "Smith"}, created_at: "19.06.2017"}
		]
	},

	{ id: 6, name: "Tapas & Friends", email: "info@tapasandfriends.ch", phone: " 044 542 89 89",
	web: "http://tapasandfriends.ch/de/", address: "Aemtlerstrasse 86, 8003 Zürich",
	reviews: [
		{ id: 1, content: "vegan curry wurst", rate: 5, user: { id: 1, firstName: "Susan", lastName: "Johnson"}, created_at: "20.06.2017"},
		{ id: 2, content: "best fries in town", rate: 4, user: { id: 2, firstName: "Robert", lastName: "Smith"}, created_at: "19.06.2017"}
		]
	}
]

const restaurants = (state = initialState, action) => {
  return state;
}

export default restaurants;
