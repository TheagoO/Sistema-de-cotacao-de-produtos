var btn = document.getElementById("menu");


btn.addEventListener('click', function(){
	var div = document.querySelector('.menu-area');
	
	if(div.style.display === 'block'){
		div.style.display = 'none';
	}
	
});


