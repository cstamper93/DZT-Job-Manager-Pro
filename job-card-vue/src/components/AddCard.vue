<template>
    <div id="form-container" class="form-container">
        <form class="form-form" @submit.prevent="addCard">
            <h3 class="new-card-header">Add New Card</h3>
            <div class="flex-container">
                <label for="jobNumber" class="input-label">Job #: </label>
                <input
                    type="number"
                    id="jobNumber"
                    class="input-box"
                    placeholder="job #"
                    v-model="newCard.jobNumber"
                    required
                    />    
            </div>
            <div class="flex-container">
                <label for="clientName" class="input-label">Name: </label>
                <input
                    type="text"
                    id="clientName"
                    class="input-box"
                    placeholder="name"
                    v-model="newCard.clientName"
                    required
                    />    
            </div>
            <div class="flex-container">
                <label for="phoneNumber" class="input-label">Phone: </label>
                <input
                    type="text"
                    id="phoneNumber"
                    class="input-box"
                    placeholder="phone"
                    v-model="newCard.phoneNumber"
                    required
                    />    
            </div>
            <div class="flex-container">
                <label for="clientEmail" class="input-label">Email: </label>
                <input
                    type="text"
                    id="clientEmail"
                    class="input-box"
                    placeholder="email"
                    v-model="newCard.clientEmail"
                    required
                    />    
            </div>
            <div class="flex-container">
                <label for="jobAddress" class="input-label">Address: </label>
                <input
                    type="text"
                    id="jobAddress"
                    class="input-box"
                    placeholder="address"
                    v-model="newCard.jobAddress"
                    required
                    />    
            </div>
            <div class="flex-container">
                <label for="jobType" class="input-label">Job Type: </label>
                <input
                    type="text"
                    id="jobType"
                    class="input-box"
                    placeholder="job type"
                    v-model="newCard.jobType"
                    required
                    />    
            </div>
            <div class="flex-container">
                <label for="completeBy" class="input-label">Complete By: </label>
                <input
                    type="date"
                    id="completeBy"
                    class="input-box"
                    v-model="newCard.completeBy"
                    required
                    />    
            </div>
            <button class="new-card-button" type="submit">
                Add Card
            </button>
        </form>
    </div>
</template>

<script>
import BackendService from '../Services/BackendService.js';

export default {
    name: "add-card",

    data() {
        return {
            newCard: {
                jobNumber: null,
                clientName: null,
                phoneNumber: null,
                altPhoneNumber: null,
                clientEmail: null,
                altEmail: null,
                jobAddress: null,
                jobType: null,
                jobStatus: "Not started",
                completeBy: null 
            }
        }
    },
    methods: {
        addCard() {
            BackendService.addJobCard(this.newCard).then((response) => {
                if(response.status === 201) {
                    alert("New card added.");
                    this.$router.go();
                }
            })
        }
    }

}
</script>

<style scoped>

</style>
