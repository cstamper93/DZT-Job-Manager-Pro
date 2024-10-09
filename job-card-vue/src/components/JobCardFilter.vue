<template>
  <form class="filter-form">

    <input type="radio" id="jobNumber" value="jobNumber" v-model="checkedChoice">
    <label for="jobNumber"> Job Number</label>

    <input type="radio" id="name" value="name" v-model="checkedChoice">
    <label for="name"> Client Name</label>

    <input type="radio" id="type" value="type" v-model="checkedChoice">
    <label for="type"> Job Type</label>

  </form>

  <input v-if="!isTypeSelected" type="text" placeholder="Filter Search" v-model="userInput">
  
  <div v-else class="select-job-type">
    <p>Select Type:</p>

    <input type="radio" id="fs" value="Field Survey" v-model="userInput">
    <label for="fs">Field Survey</label>

    <input type="radio" id="eps" value="Existing Parcel Survey" v-model="userInput">
    <label for="eps">Existing Parcel</label>

    <input type="radio" id="division" value="Division" v-model="userInput">
    <label for="division">Division</label>

    <input type="radio" id="recombination" value="Recombination" v-model="userInput">
    <label for="recombination">Recombination</label>

    <input type="radio" id="construction" value="Construction" v-model="userInput">
    <label for="construction">Construction</label>

    <input type="radio" id="other" value="Other" v-model="userInput">
    <label for="other">Other </label>
    <textarea v-if="isOther" v-model="userInput"></textarea>
  </div>

  <button @click="filter(userInput)">Search</button>

  <router-link v-bind:to="{name: 'Job-Card-Details'}">
  <div class="filtered-job-cards" v-for="filteredCard in filteredCards" v-bind:key="filteredCard.id"
    @click="saveUserChoice(filteredCard.id)">
    <p>Job #: {{ filteredCard.jobNumber }}</p>
    <p>Job Address: {{ filteredCard.jobAddress }}</p>
    <p>Status: {{ filteredCard.jobStatus }}</p>
    <p>Complete By: {{ filteredCard.completeBy }}</p>
  </div>
  </router-link> 

</template>

<script>
import BackendService from '../Services/BackendService';

export default {


    name: 'job-card-filter',

    data() {
        return {
            userInput: null,
            checkedChoice: null,
            jobTypeChoice: null,
            filteredCards: []
        }
    },
    methods: {
        filterByNumber(num) {
            BackendService.filterCardsByNum(num).then((response) => {
                if(response.status == 200) {
                    this.filteredCards = response.data;
                    // this.$router.go();
                } else {
                    alert("A problem occurred. Please try again.");
                }
            });
        },

        filterByName(name) {
            BackendService.filterCardsByName(name).then((response) => {
                if(response.status == 200) {
                    this.filteredCards = response.data;
                } else {
                    alert("A problem occurred. Please try again.");
                }
            });
        },

        filter(userInput) {
            if(this.checkedChoice == "jobNumber") {
                BackendService.filterCardsByNum(userInput).then((response) => {
                    if(response.status == 200) {
                        this.filteredCards = response.data;
                    } else {
                        alert("A problem occurred. Please try again.");
                    }
                });
            } else if(this.checkedChoice == "name") {
                BackendService.filterCardsByName(userInput).then((response) => {
                    if(response.status == 200) {
                        this.filteredCards = response.data;
                    } else {
                        alert("A problem occurred. Please try again.");
                        console.log(response.status)
                    }
                });  
            } else if(this.checkedChoice == "type") {
                BackendService.filterCardsByType(userInput).then((response) => {
                    if(response.status == 200) {
                        this.filteredCards = response.data;
                    } else {
                        alert("A problem occurred. Please try again.");
                        console.log(response.status)
                    }
                });
            } else {
                alert("A problem occurred with your choice. Please try again.")
            }
        },

        saveUserChoice(id) {
            try {
                localStorage.setItem('userChoice', id);
            } catch(error) {
                console.error('Error saving selection: ', error);
            }
        }
    },

    computed: {
        isTypeSelected() {
            if(this.checkedChoice == "type") {
                return true;
            } else {
                return false;
            }
        },
        isOther() {
            if(this.userInput="Other") {
                return true;
            } else {
                return false;
            }
        }
    }
}
</script>

<style scoped>
.filtered-job-cards {
   margin-top: 3rem;
   padding: 5px;
   margin: 8px;
   border: 1px solid black;
   border-radius: 7px;
   width: 275px;
}

.filtered-job-cards:hover {
    border: 2px solid black;
    background-color: #f0ffff;
}

.select-job-type {
    margin-top: 0.7rem;
}

</style>