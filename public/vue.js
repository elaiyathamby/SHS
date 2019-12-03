


Vue.component('lamp', {
    data: function () {
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
                        </div><br>
                        <label for="customRange3">Brightness</label>
                        <input type="range" class="custom-range" min="0" max="5" step="0.5" id="customRange3">
                    </p>
                </div>
            </div>
        `
})

Vue.component('room', {
    data: function () {
        return {

        }
    },
    template: `
    <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="img\\living-room.jpg" alt="Living Room">
                <div class="card-body">
                    <h5 class="card-title">Living Room</h5>
                    <p class="card-text">
                        <p>Light</p>
                        <label class="switch">
                            <input type="checkbox">
                            <span class="slider round"></span>
                        </label>
                    </p>
                    <p>
                        <label for="customRange3">Brightness</label>
                        <input type="range" class="custom-range" min="0" max="5" step="0.5" id="customRange3">
                    <p/>
                    <p class="card-text">Room Temp <input type="number" value="24"></p>
                </div>
            </div>
        `
})

Vue.component('tv', {
    data: {
        tvname: 'Phillips'
    },
    template: `
    <div class="card" style="width: 18rem;" >
                <img class="card-img-top" src="img\\smart_tv.jpeg" alt="Smart Tv">
                <div class="card-body">
                    <h5 class="card-title">{{ this.tvname}} Smart TV</h5>
                    <p class="card-text">
                        <p>TV Power</p>
                        <label class="switch">
                            <input type="checkbox">
                            <span class="slider round"></span>
                        </label>
                    </p>
                    <p>
                        <label for="customRange3">Sound Level</label>
                        <input type="range" class="custom-range" min="0" max="5" step="0.5" id="customRange3">
                    </p>
                    <p class="card-text">Chanel <input type="number" value="42"></p>
                </div>
            </div>
        `
})

Vue.component('app-level', {
    data: function () {
        return {

        }
    },
    props: ['title', 'subMenueNumber'],
    template: `
        <li>
            <a href="#subMenueNumber" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle btn">
                <i class="fas fa-copy"></i>
                {{ title }}
            </a>
            <ul class="collapse list-unstyled" id="subMenueNumber">
                <li>
                    <a href="#" onclick="changeRoom('Master Room')" class="btn btn-secondary">Master Room</a>
                </li>
                <li>
                    <a href="#" onclick="changeRoom('Bathroom')" class="btn btn-secondary">Bathroom</a>
                </li>
                <li>
                    <a href="#" onclick="changeRoom('Kids Room')" class="btn btn-secondary">Kids Room</a>
                </li>
            </ul>
        </li>
            `
})

var nav = new Vue({
    el: '#app-nav',
    data: {
        title: "Level 3",
        subMenueNumber: "lvl"
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