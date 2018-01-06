Vue.component('user-menu', {
	 template: '#user-menu-template',
	  methods: {
		    openLoginWindow: function () {
		    	bus.$emit('user-login-window-event')
		    }
		  }
})
