<template>
  <form class="filter-form">

    <input type="checkbox" id="jobNumber" name="jobNumber">
    <label for="jobNumber"> Job Number</label>

    <input type="checkbox" id="name" name="name">
    <label for="name"> Client Name</label>

    <input type="checkbox" id="type" name="type">
    <label for="type"> Job Type</label>

  </form>

  <input type="text" placeholder="Filter Search" v-model="filterChoice">
  <button @click.prevent="filterByNumber(filterChoice)">Search</button>

  <div class="filtered-job-cards">
    <p>Job #: {{ filteredCards.jobNumber }}</p>
    <p>Job Address: {{ filteredCards.jobAddress }}</p>
    <p>Status: {{ filteredCards.jobStatus }}</p>
    <p>Complete By: {{ filteredCards.completeBy }}</p>
  </div>

</template>

<script>
import BackendService from '../Services/BackendService';

export default {


    name: 'job-card-filter',

    data() {
        return {
            filterChoice: null,
            filteredCards: []
        }
    },
    methods: {
        filterByNumber(num) {
            BackendService.filterCardsByNum(num).then((response) => {
                if(response.status == 200) {
                    this.filteredCards = response.data;
                    this.$router.go();
                } else {
                    alert("A problem occurred. Please try again.");
                }
            });
        }
    }

}
</script>

<style>

</style>