$(function(){

	var all = $('#all');
	var dev = $('#dev');
	var pho = $('#pho');
	var des = $('#des');
	var grid = $('.grid');

	grid.isotope({
	  itemSelector: '.grid-item',
	  masonry: {
	    columnWidth: 270
	  }
	});

	all.click(function(){
		grid.isotope({ filter: '.grid-item' });
		event.preventDefault();
	});

	dev.click(function(){
		grid.isotope({ filter: '.dev' });
		event.preventDefault();
	});

	pho.click(function(){
		grid.isotope({ filter: '.pho' });
		event.preventDefault();
	});

	des.click(function(){
		grid.isotope({ filter: '.des' });
		event.preventDefault();
	});

});