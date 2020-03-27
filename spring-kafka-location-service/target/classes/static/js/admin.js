$( document ).ready(function() {

	var sse = $.SSE('/kafka-messages', {
	    onMessage: function(e){ 
	        console.log(e); 
	        var obj = JSON.parse(e.data);

	        $('#kafka-messages tr:last').after('<tr><td>'+obj.id+'</td><td>'+obj.make+'</td><td>'+obj.variant+'</td><td>'+obj.model+'</td><td>'+obj.cost+'</td></tr>');
	    },
	    onError: function(e){ 
	    	sse.stop();
	        console.log("Could not connect..Stopping SSE"); 
	    },
	    onEnd: function(e){ 
	        console.log("End"); 
	    }
	});
	sse.start();
  
});