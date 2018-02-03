Vue.component('lang-menu', {
	 template: '<div>{{_LANG("LANGUAGE")}}:<template v-for="item in items"><a :href="\'/portal?lang=\'+ item"><img style="margin-left: 5px" :src="\'/images/lang/\'+item+\'.png\'"/></a></template></div>',
	 data() {
		  return {
			  items: jSite.languages
		  }
		}
})
