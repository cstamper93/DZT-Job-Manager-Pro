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
                <p>Job Type: </p>
                <input
                    type="radio"
                    id="fs"
                    value="Field Survey"
                    class="input-box"
                    v-model="newCard.jobType"
                    required
                    />
                <label for="fs">Field Survey</label>

                <input
                    type="radio"
                    id="eps"
                    value="Existing Parcel"
                    class="input-box"
                    v-model="newCard.jobType"
                    required
                    />
                <label for="eps">Existing Parcel</label>

                <input
                    type="radio"
                    id="division"
                    value="Division"
                    class="input-box"
                    v-model="newCard.jobType"
                    required
                    />
                <label for="division">Division</label>

                <input
                    type="radio"
                    id="recombination"
                    value="Recombination"
                    class="input-box"
                    v-model="newCard.jobType"
                    required
                    />
                <label for="recombination">Recombination</label>

                <input
                    type="radio"
                    id="construction"
                    value="Construction"
                    class="input-box"
                    v-model="newCard.jobType"
                    required
                    />
                <label for="construction">Construction</label>

                <input
                    type="radio"
                    id="other"
                    value="other"
                    class="input-box"
                    v-model="newCard.jobType"
                    required
                    />
                <label for="other">Other: </label>   
                <textarea v-if="isOther" class="other-bar" v-model="newCard.jobType"></textarea>
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
                completeBy: null,
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
    },
    computed: {
        isOther() {
            if(this.newCard.jobType=="other") {
                return true;
            } else {
                return false;
            }
        }
    }

}
</script>

<style scoped>

</style>
