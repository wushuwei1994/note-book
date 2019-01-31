var app = new Vue({
	el: '#app',
	data: {
		message: '',
		// now: Date.now()
	},
	computed: {
		reversedMessage1: function(){
			return this.message.split('').reverse().join('');
		},
		now: function () {
		    return Date.now()
		}
	},
	methods: {
		reversedMessage:function(){
			return this.message.split('').reverse().join('');
		}
	}
})