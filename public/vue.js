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
                                <a class="dropdown-item" href="#" onclick="changeColor('dropdownColor','red')" >Red</a>
                                <a class="dropdown-item" href="#" onclick="changeColor('dropdownColor','green');">Green</a>
                                <a class="dropdown-item" href="#" onclick="changeColor('dropdownColor','blue');">Blue</a>
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
    data: function () {
        return {
            tvname: 'Phillips'
        }
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
    props: ['title', 'sml', 'smlref'],
    template: `
        <li>
            <a v-bind:href="smlref" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle btn">
                <i class="fas fa-copy"></i>
                {{ title }}
            </a>
            <ul class="collapse list-unstyled" v-bind:id="sml">
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
    el: '#app-main',
    data: {
        inRoom: "",
        house: "Houses",
        houses: [],
        floors: [],
        rooms: [],
    },
    mounted: function () {
        this.getHouses();
    },
    methods: {
        setHouse: function (name) {
            this.house = name;
        },
        setRoom: function (name) {
            this.inRoom = name;
        },
        getHouses: function () {
            axios.get("http://127.0.0.1:8090/house")
                .then((res) => {
                    this.houses = res.data;
                })
        },
        getFloorsByHouse: function (houseid, housename) {
            this.setHouse(housename);
            axios.get("http://127.0.0.1:8090/floor/house/" + houseid)
                .then((res) => {
                    this.floors = res.data;
                })
        },
        getRoomsByFloor: function (floorid) {
            axios.get("http://127.0.0.1:8090/room/floor/" + floorid)
                .then((res) => {
                    this.rooms = res.data;
                })
        },
    },
    
})

