


Vue.component('card',{
    data:function(){
        return {

        }
    },
    template: `
    <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="img\\Philips-LivingColors.jpg" alt="Philips-LivingColors">
                <div class="card-body">
                    <h5 class="card-title">Philips-LivingColors</h5>
                    <p>Light</p>
                    <label class="switch">
                        <input type="checkbox">
                        <span class="slider round"></span>
                    </label>
                    <p class="card-text">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownColor"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Color
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownColor">
                                <a class="dropdown-item" href="#" onclick="changeColor('dropdownColor','red');">Red</a>
                                <a class="dropdown-item" href="#"
                                    onclick="changeColor('dropdownColor','green');">Green</a>
                                <a class="dropdown-item" href="#"
                                    onclick="changeColor('dropdownColor','blue');">Blue</a>
                            </div>
                        </div>
                    </p>
                </div>
            </div>
        `
})

var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello ',
        person: {
            firstname: "Subash"
        },
        names: [
            "Subash",
            "Peter",
            "Mätu",
            "Jo-L",
            "Chrisi MacChris"
        ],
        title: "My first Vue app",
        isDisabled: false,
        showMessage: false,
        movieTitle: "Please add a movie",
        movies: [
            { name: "Avangers 1" },
            { name: "Avangers 2" },
            { name: "Avangers 3" },
            { name: "Avangers 4" }
        ]
    },
    methods: {
        changeMsg: function (text) {
            this.message = text;
        },
        addMovie: function () {
            if (this.movieTitle != "") {
                this.movies.push({ name: this.movieTitle });
                if (this.movies.length >= 5) {
                    this.isDisabled = true;
                    this.showMessage = true;
                }
            }

        }
    }
})