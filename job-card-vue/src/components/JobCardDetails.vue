<template>
  <h1>Job Card # {{ jobCard.jobNumber }}</h1>
    <div class="card-details-page">

        <h3 class="headline">Client Name: </h3>
        <div class="property-container" @mouseenter="lineHover=true, nameHover=true" 
        @mouseleave="lineHover=false, nameHover=false" v-if="!editName">
            <span v-if="jobCard.clientName!=null && jobCard.clientName.length!=0">{{ jobCard.clientName }}</span>
            <span v-else>N/A</span>
            <img v-if="nameHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editName=true">
        </div> 
        <div class="editLine" v-if="editName">
            <input class="input-box" type="text" placeholder="Name" required autofocus v-model="jobCard.clientName"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editName=false">Cancel</button>
        </div>

        <h3 class="headline">Phone Number: </h3>
        <div class="property-container" @mouseenter="lineHover=true, phoneHover=true" 
        @mouseleave="lineHover=false, phoneHover=false" v-if="!editPhoneNumber">
            <span v-if="jobCard.phoneNumber!=null && jobCard.phoneNumber.length!=0">{{ jobCard.phoneNumber }}</span>
            <span v-else>N/A</span>
            <img v-if="phoneHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editPhoneNumber=true">
        </div>  
        <div class="editLine" v-if="editPhoneNumber">
            <input class="input-box" type="text" placeholder="Phone Number" required autofocus v-model="jobCard.phoneNumber"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editPhoneNumber=false">Cancel</button>
        </div>

        <h3 class="headline">Alternate Phone Number: </h3>
        <div class="property-container" @mouseenter="lineHover=true, altPhoneHover=true" 
        @mouseleave="lineHover=false, altPhoneHover=false" v-if="!editAltPhone">
            <span v-if="jobCard.altPhoneNumber!=null && jobCard.altPhoneNumber.length!=0">{{ jobCard.altPhoneNumber }}</span>
            <span v-else>N/A</span>
            <img v-if="altPhoneHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editAltPhone=true">
        </div>    
        <div class="editLine" v-if="editAltPhone">
            <input class="input-box" type="text" placeholder="Alt Phone Number" required autofocus v-model="jobCard.altPhoneNumber"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editAltPhone=false">Cancel</button>
        </div>

        <h3 class="headline">Client Email: </h3>
        <div class="property-container" @mouseenter="lineHover=true, emailHover=true" 
        @mouseleave="lineHover=false, emailHover=false" v-if="!editEmail">
            <span v-if="jobCard.clientEmail!=null && jobCard.clientEmail.length!=0">{{ jobCard.clientEmail }}</span>
            <span v-else>N/A</span>
            <img v-if="emailHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editEmail=true">
        </div>

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

            lineHover: false,
            nameHover: false,
            phoneHover: false,
            altPhoneHover: false,
            emailHover: false,

            editJobNumber: false,
            editName: false,
            editPhoneNumber: false,
            editAltPhone: false,
            editEmail: false,
            editAltEmail: false,
            editAddress: false,
            editType: false,
            editStatus: false,
            editDate: false
            
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
        editJobCard(jobCard) {
            BackendService.editJobCard(jobCard).then((response) => {
                if(response.status === 200) {
                    alert(`Changes to job ${jobCard.jobNumber} have been saved.`);
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