var data = {
		showLoginWindow: false
}

Vue.component('user-windows', {
	template: '#user-windows-template',
		 data: function () {
			    return data
		  },
		  created() {
			 
			    bus.$on('user-login-window-event', function () {
			      data.showLoginWindow = true;			      
			    })
			  }
});

Vue.component('user-login-window', {
	 template: '#modal-template',
	 data: function () {
		    return data
	  },
	  created() {
			 
		    bus.$on('close-login-window', function () {
		      data.showLoginWindow = false;			      
		    })
		  }
})