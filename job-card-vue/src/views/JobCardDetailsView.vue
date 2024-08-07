<template>
    <h1>Job Card {{ jobCard.jobNumber }}</h1>
    <div class="card-details-page">
        <h3 class="headline">Client Name: </h3>
        <span v-if="jobCard.clientName!=null && jobCard.clientName.length!=0">{{ jobCard.clientName }}</span>
        <span v-else>N/A</span>
        <h3 class="headline">Phone Number: </h3>
        <span v-if="jobCard.phoneNumber!=null && jobCard.phoneNumber.length!=0">{{ jobCard.phoneNumber }}</span>
        <span v-else>N/A</span>
        <h3 class="headline">Alternate Phone Number: </h3>
        <span v-if="jobCard.altPhoneNumber!=null && jobCard.altPhoneNumber.length!=0">{{ jobCard.altPhoneNumber }}</span>
        <span v-else>N/A</span>
        <h3 class="headline">Client Email: </h3>
        <span v-if="jobCard.clientEmail!=null && jobCard.clientEmail.length!=0">{{ jobCard.clientEmail }}</span>
        <span v-else>N/A</span>
        <h3 class="headline">Alternate Email: </h3>
        <span v-if="jobCard.altEmail!=null && jobCard.altEmail.length!=0">{{ jobCard.altEmail }}</span>
        <span v-else>N/A</span>
        <h3 class="headline">Job Address: </h3>
        <span v-if="jobCard.jobAddress!=null && jobCard.jobAddress!=0">{{ jobCard.jobAddress }}</span>
        <span v-else>N/A</span>
        <h3 class="headline">Job Type: </h3>
        <span v-if="jobCard.jobType!=null && jobCard.jobType.length!=0">{{ jobCard.jobType }}</span>
        <span v-else>N/A</span>
        <h3 class="headline">Status: </h3>
        <span v-if="jobCard.jobStatus!=null && jobCard.jobStatus.length!=0">{{ jobCard.jobStatus }}</span>
        <span v-else>N/A</span>
        <h3 class="headline">Complete By: </h3>
        <span v-if="jobCard.completeBy!=null">{{ jobCard.completeBy }}</span>
        <span v-else>N/A</span>
    </div>
</template>

<script>
import BackendService from '../Services/BackendService.js'

export default {
    name: 'job-card-details-view',
    data() {
        return {
            jobCard: Object
        }
    },
    created() {
        BackendService.getJobCardById(this.userChoice).then((response) => {
            if(response.status === 200) {
                this.jobCard = response.data;
            }
        })
    },
    computed: {
        userChoice() {
            try {
                const userChoice = localStorage.getItem('userChoice');
                return Number(userChoice);
            } catch(error) {
                console.error('Error retrieving job card: ', error);
                return null;
            }
        }
    }

}
</script>

<style>
    .card-details-page {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 20px;
    }

    .headline {
        font-weight: bold;
        text-align: right;
        margin-right: 0.5rem;
    }

    span {
        margin-left: 0.5rem;
        text-align: left;
    }

    h1 {
        text-align: center;
        margin-top: 1.5rem;
        margin-bottom: 1.5rem;
    }

</style>