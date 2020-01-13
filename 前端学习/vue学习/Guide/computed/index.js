var app = new Vue({
	el: '#app',
	data: {
		message: '',
		// now: Date.now()
		firstName: 'Foo',
    	lastName: 'Bar',
    	// fullName: 'Foo Bar',
    	// fullName: ''
	},
	computed: {
		reversedMessage1: function(){
			return this.message.split('').reverse().join('');
		},
		now: function () {
		    return Date.now()
		},
		// fullName: function(){
		// 	return this.firstName + ' ' + this.lastName
		// }
		fullName: {
			get: function(){

				return this.firstName + ' ' + this.lastName
			},
			set: function(newValue){
				console.log(newValue)
				var names = newValue.split(' ');
				this.firstName = names[0]; // 123
				console.log(this.firstName)
				this.lastName = names[names.length - 1]; // 
				// alert(this.fullName)
			}
		}
	},
	methods: {
		reversedMessage:function(){
			return this.message.split('').reverse().join('');
		}
	},
	// watch: {
	// 	firstName: function(val) {
	// 		this.fullName = val + ' ' + this.lastName
	// 	},
	// 	lastName: function(val) {
	// 		this.fullName = this.firstName + ' ' + val
	// 	}
	// }
})