<template>
    <div>
        <h1>Jobs Board</h1>
        <div class="job-card" v-for="jobCard in jobCardsList" v-bind:key="jobCard.id">
            <p>Job Number: {{ jobCard.jobNumber }}</p>
            <p>Job Address: {{ jobCard.jobAddress }}</p>
            <p>Status: {{ jobCard.jobStatus }}</p>
            <p>Complete By: {{ jobCard.completeBy }}</p>
        </div>
    </div>
</template>

<script>
import backendService from '../Services/BackendService.js';

export default {
    name: "job-cards-list",
    data() {
        return {
            jobCards: [],
            isLoading: true
        };
    },
    created() {
        backendService.getAllJobCards().then(
            (response) => {
                this.jobCards = response.data;
                this.isLoading = false;
            }
        );
    }
}
</script>

<style scoped>
.job-card {
    padding: 5px;
    margin: 5px;
    border: 1px;
    width: 250px;
    background-color: blue;
}
</style>