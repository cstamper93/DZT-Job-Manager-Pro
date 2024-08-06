<template>
    <div>
        <button class="delete-button" @click="deleteCard = !deleteCard" v-if="!deleteCard">Delete Card</button>
        <button class="delete-button" @click="deleteCard = !deleteCard" v-if="deleteCard">Done</button>

        <div class="job-card-container" v-for="jobCard in jobCards" v-bind:key="jobCard.id">
            <div class="delete-btn-container">
                <button v-if="deleteCard" @click="deleteJobCard(jobCard.id)">Delete</button>
            </div>
            <div class="job-card">
                <p>Job #: {{ jobCard.jobNumber }}</p>
                <p>Job Address: {{ jobCard.jobAddress }}</p>
                <p>Status: {{ jobCard.jobStatus }}</p>
                <p>Complete By: {{ jobCard.completeBy }}</p>
            </div>
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
            deleteCard: false,
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
    },
    methods: {
        deleteJobCard(id) {
            backendService.deleteJobCard(id).then((response) => {
                if(response.status === 204) {
                    alert("Card deleted");
                    this.$router.go();
                }
            });
        }
    }
}
</script>

<style scoped>
.job-card {
    padding: 5px;
    margin: 8px;
    border: 1px solid black;
    border-radius: 7px;
    width: 275px;
}
</style>