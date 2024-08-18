<template>
  <form class="filter-form">

    <input type="checkbox" id="jobNumber" value="jobNumber" v-model="checkedChoices">
    <label for="jobNumber"> Job Number</label>

    <input type="checkbox" id="name" value="name" v-model="checkedChoices">
    <label for="name"> Client Name</label>

    <input type="checkbox" id="type" value="type" v-model="checkedChoices">
    <label for="type"> Job Type</label>

  </form>

  <input type="text" placeholder="Filter Search" v-model="userInput">
  <button @click="filterByNumber(userInput)">Search</button>

  <div class="filtered-job-cards" v-for="filteredCard in filteredCards" v-bind:key="filteredCard.id">
    <p>Job #: {{ filteredCard.jobNumber }}</p>
    <p>Job Address: {{ filteredCard.jobAddress }}</p>
    <p>Status: {{ filteredCard.jobStatus }}</p>
    <p>Complete By: {{ filteredCard.completeBy }}</p>
  </div>

</template>

<script>
import BackendService from '../Services/BackendService';

export default {


    name: 'job-card-filter',

    data() {
        return {
            userInput: null,
            checkedChoices: [],
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
        }
    },
    computed: {
        // figure out how to run correct method based on checkboxes
    }
}
</script>

<style scoped>
.filtered-job-cards {
   margin-top: 3rem;
}

</style>