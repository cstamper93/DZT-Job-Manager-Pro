<template>
    <div>
        <button class="delete-button" @click="deleteCard = !deleteCard" v-if="!deleteCard">Delete Card(s)</button>
        <button class="delete-button" @click="deleteCard = !deleteCard" v-if="deleteCard">Done</button>

        <div class="job-card-container" v-for="jobCard in jobCards" v-bind:key="jobCard.id">
            <div class="delete-btn-container">
                <button v-if="deleteCard" @click.prevent="deleteJobCard(jobCard)">Delete</button>
            </div>
            <router-link v-bind:to="{name: 'Job-Card-Details'}">
            <div class="job-card" @mouseenter="hover=true" @mouseleave="hover=false" 
            @click="saveUserChoice(jobCard.id)">
                <p>Job #: {{ jobCard.jobNumber }}</p>
                <p>Job Address: {{ jobCard.jobAddress }}</p>
                <p>Status: {{ jobCard.jobStatus }}</p>
                <p>Complete By: {{ jobCard.completeBy }}</p>
            </div>
            </router-link>
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
            hover: false,
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
        deleteJobCard(jobCard) {
            backendService.deleteJobCard(jobCard.id).then((response) => {
                if(response.status === 204) {
                    alert(`Job ${jobCard.jobNumber} deleted.`);
                    this.$router.go();
                }
            });
        },
        saveUserChoice(id) {
            try {
                localStorage.setItem('userChoice', id);
            } catch(error) {
                console.error('Error saving selection: ', error);
            }
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

.job-card:hover {
    border: 2px solid black;
    background-color: #f0ffff;
}

.job-card-container {
    display: flex;
    align-items: center;
}

</style>