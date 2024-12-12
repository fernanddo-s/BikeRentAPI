<script setup>
import { onMounted, reactive } from 'vue';
import { create, update } from '@/services/TotemService'

const variaveis = reactive({
  dialog:false,
  totem:{
    id: 0,
    localizacao: '',
    capacidade: '',
    descricao: '',
  },
})

const props = defineProps({
  totem:{
    localizacao: String,
    capacidade: Number,
    descricao: String,
  },
  icon: '',
  editando: Boolean
})

async function save(id, totem) {
  if(props.editando){
    update(id, totem)
  }else{
    create(totem);
  }
  variaveis.dialog = false
  limparForm()
}

function limparForm(){
  variaveis.totem.localizacao = '';
  variaveis.totem.capacidade = '';
  variaveis.totem.descricao = '';
}

onMounted(async () => {
  if(props.editando){
    variaveis.totem.localizacao = props.totem.localizacao;
    variaveis.totem.capacidade = props.totem.capacidade;
    variaveis.totem.descricao = props.totem.descricao;
  }
})
</script>

<template>
  <div class="pa-4 text-center">
    <v-dialog
      v-model="variaveis.dialog"
      max-width="800"
    >
      <template v-slot:activator="{ props: activatorProps }">
        <v-icon
          class="mr-3 btn-actions" color="primary"
          v-bind="activatorProps"
        >{{ props.icon }}</v-icon>
      </template>

      <v-card title="Totem Form">
        <v-card-text v-if="props.editando">
          <v-row>
            <v-col cols="12" md="6" sm="6">
              <v-text-field label="Localização*" v-model="variaveis.totem.localizacao"></v-text-field>
            </v-col>
            <v-col>
              <v-text-field type="number" label="Capacidade*" v-model="variaveis.totem.capacidade"></v-text-field>
            </v-col>

            <v-col cols="12" md="6" sm="6">
              <v-text-field type="text" label="Descrição" v-model="variaveis.totem.descricao" ></v-text-field>
            </v-col>
          </v-row>
          <small class="text-caption text-medium-emphasis">*indica campo obrigatório</small>
        </v-card-text>
        <v-card-text v-else>
          <v-row>
            <v-col cols="12" md="6" sm="6">
              <v-text-field label="Localização*" v-model="variaveis.totem.localizacao"></v-text-field>
            </v-col>
            <v-col>
              <v-text-field type="number" label="Capacidade*" v-model="variaveis.totem.capacidade"></v-text-field>
            </v-col>

            <v-col cols="12" md="6" sm="6">
              <v-text-field type="text" label="Descrição" v-model="variaveis.totem.descricao" ></v-text-field>
            </v-col>
          </v-row>
          <small class="text-caption text-medium-emphasis">*indica campo obrigatório</small>
        </v-card-text>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn text="Cancelar" @click="variaveis.dialog = false"></v-btn>
          <v-btn color="primary" text="Salvar" @click="save(props.totem.id, variaveis.totem)"></v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>