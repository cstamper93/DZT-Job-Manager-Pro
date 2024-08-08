<template>
  <h1>Job Card {{ jobCard.jobNumber }}</h1>
    <div class="card-details-page">
        <h3 class="headline">Client Name: </h3>
        <div class="property-container" @mouseenter="lineHover=true, nameHover=true" 
        @mouseleave="lineHover=false, nameHover=false" v-if="!showEdit">
            <span v-if="jobCard.clientName!=null && jobCard.clientName.length!=0">{{ jobCard.clientName }}</span>
            <span v-else>N/A</span>
            <img v-if="nameHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="showEdit=true">
        </div> 

        <div class="editLine" v-if="showEdit">
            <input class="input-box" type="text" value="Name" v-model="newJobCard.clientName"/>
            <button>Submit</button>
            <button @click="showEdit=false">Cancel</button>
        </div>

        <h3 class="headline">Phone Number: </h3>
        <div class="property-container" @mouseenter="lineHover=true, phoneHover=true" 
        @mouseleave="lineHover=false, phoneHover=false">
            <span v-if="jobCard.phoneNumber!=null && jobCard.phoneNumber.length!=0">{{ jobCard.phoneNumber }}</span>
            <span v-else>N/A</span>
            <img v-if="phoneHover" src="../components/icons/edit.png" alt="Pencil Icon">
        </div>  
        <h3 class="headline">Alternate Phone Number: </h3>
        <div class="property-container" @mouseenter="lineHover=true, altPhoneHover=true" 
        @mouseleave="lineHover=false, altPhoneHover=false">
            <span v-if="jobCard.altPhoneNumber!=null && jobCard.altPhoneNumber.length!=0">{{ jobCard.altPhoneNumber }}</span>
            <span v-else>N/A</span>
            <img v-if="altPhoneHover" src="../components/icons/edit.png" alt="Pencil Icon">
        </div>    
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
    name: 'job-card-details',
    data() {
        return {
            jobCard: Object,
            newJobCard: {
                jobNumber: null,
                clientName: null,
                phoneNumber: null,
                altPhoneNumber: null,
                clientEmail: null,
                altEmail: null,
                jobAddress: null,
                jobType: null,
                jobStatus: null,
                completeBy: null
            },
            showEdit: false,
            lineHover: false,
            nameHover: false,
            phoneHover: false,
            altPhoneHover: false
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
    },
    methods: {
        editJobCard(card) {
            BackendService.editJobCard(card).then((response) => {
                if(response.status === 200) {
                    alert(`Changes to job ${card.id} have been saved.`);
                    this.$router.go();
                } else {
                    alert('A problem was encountered. Please try again.');
                }
            })
        }
    }

}
</script>

<style scoped>
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

    .property-container {
        display: flex;
        align-items: center;
        justify-content: space-between;
    }

    .property-container:hover {
        background-color: #f0ffff;
    }

    img {
        width: 1.1rem;
        height: 1.1rem;
    }

    img:hover {
        width: 1.25rem;
        height: 1.25rem;
    }

</style>