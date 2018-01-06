Vue.component('user-menu', {
	 template: '#user-menu-template',
	  methods: {
		    openLoginWindow: function () {
		     $("#user-login-window").modal("toggle");
		    }
		  }
})