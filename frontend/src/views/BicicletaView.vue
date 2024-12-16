<!-- <script setup>
import { onMounted, reactive } from 'vue';
import { getBicicletas, apagar } from '@/services/BicicletaService';
import Header from '@/components/header/Header.vue';
import DialogDelete from '@/components/dialogDelete/DialogDelete.vue';
import BicicletaForm from '@/components/forms/BicicletaForm.vue';

const variaveis = reactive({
  bicicletas: [
    {
        "id": 5,
        "numero": 1,
        "marca": "Monark",
        "modelo": "Barra Circular",
        "ano": "2024",
        "status": "NOVA"
    },
    {
        "id": 7,
        "numero": 123,
        "marca": "Colli",
        "modelo": "Full Suspension",
        "ano": "2024",
        "status": "NOVA"
    },
    {
        "id": 8,
        "numero": 123,
        "marca": "Colli",
        "modelo": "Full Suspension",
        "ano": "2024",
        "status": "NOVA"
    },
    {
        "id": 1,
        "numero": 121,
        "marca": "Outra marca",
        "modelo": "XYT-400",
        "ano": "2024",
        "status": "DISPONIVEL"
    },
    {
        "id": 3,
        "numero": 1,
        "marca": "Monark02",
        "modelo": "Barra Circular",
        "ano": "2024",
        "status": "DISPONIVEL"
    },
    {
        "id": 6,
        "numero": 123,
        "marca": "Colli",
        "modelo": "Full Suspension",
        "ano": "2024",
        "status": "DISPONIVEL"
    }
], 
  headers: [
    { title: "Número", key: "numero" },
    { title: "Marca", key: "marca" },
    { title: "Modelo", key: "modelo" },
    { title: "Ano", key: "ano" },
    { title: "Status", key: "status" },
    { title: "Ações", key: "actions" },
  ]
});

function apagarBicicleta(id) {
  apagar(id);
}

</script>

<template>
  <Header></Header>
  <div class="div">
    <v-data-table :items="variaveis.bicicletas" :headers="variaveis.headers" class="data-table">
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Bicicletas</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <BicicletaForm :icon="'mdi-plus'"></BicicletaForm>
        </v-toolbar>
      </template>
      <template v-slot:item.actions="{ item }">
        <v-icon class="btn-actions" size="x-small">
          <BicicletaForm :bicicleta="item" :icon="'mdi-pencil'" :editando="true"></BicicletaForm>
        </v-icon>
        <v-icon size="x-small">
          <DialogDelete :item-id="item.id" :delete-func="apagarBicicleta"></DialogDelete>
        </v-icon>
      </template>
    </v-data-table>
  </div>
  
</template> -->

<template>
  <Header></Header>
  <div class="div">
      <v-data-table
      :headers="headers"
      :items="desserts"
      :sort-by="[{ key: 'calories', order: 'asc' }]"
      class="data-table"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Bicicletas</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <v-dialog v-model="dialog" max-width="800px">
            <template v-slot:activator="{ props }">
              <v-btn class="mb-2" color="primary" dark v-bind="props">
                Adicionar bicicleta
              </v-btn>
            </template>
            <v-card>
              <v-card-title>
                <span class="text-h5">{{ formTitle }}</span>
              </v-card-title>

              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12" md="5" sm="6">
                      <v-text-field v-model="editedItem.cpf" label="CPF" />
                    </v-col>
                    <v-col cols="12" md="5" sm="6">
                      <v-text-field v-model="editedItem.login" label="Login" />
                    </v-col>
                    <v-col cols="12" md="5" sm="6">
                      <v-text-field type="number" v-model="editedItem.idade" label="Idade" />
                    </v-col>
                    <v-col cols="12" md="5" sm="6">
                      <v-text-field v-model="editedItem.matricula" label="Matrcula" />
                    </v-col>
                    <v-col cols="12" md="5" sm="6">
                      <v-text-field v-model="editedItem.nome" label="Nome" />
                    </v-col>
                    <v-col cols="12" md="5" sm="6">
                      <v-text-field type="password" v-model="editedItem.senha" label="Senha" />
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue-darken-1" variant="text" @click="close">
                  Cancel
                </v-btn>
                <v-btn color="blue-darken-1" variant="text" @click="save">
                  Save
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
          <v-dialog v-model="dialogDelete" max-width="500px">
            <v-card>
              <v-card-title class="text-h5">
                Deseja realmente apagar esse item?
              </v-card-title>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue-darken-1" variant="text" @click="closeDelete">
                  Não
                </v-btn>
                <v-btn color="blue-darken-1" variant="text" @click="deleteItemConfirm">
                  Sim
                </v-btn>
                <v-spacer></v-spacer>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-toolbar>
      </template>
      <template v-slot:item.actions="{ item }">
        <v-icon class="me-2" size="small" @click="editItem(item)" color="primary">
          mdi-pencil
        </v-icon>
        <v-icon size="small" @click="deleteItem(item)" color="error">
          mdi-delete
        </v-icon>
      </template>
      <template v-slot:no-data>
        <v-btn color="primary" @click="initialize">
          Reset
        </v-btn>
      </template>
    </v-data-table>
  </div>
  
</template>

<script setup>
import Header from '@/components/header/Header.vue';
import { getBicicletas } from '@/services/BicicletaService';
import { ref, computed, nextTick } from 'vue'

const dialog = ref(false)
const dialogDelete = ref(false)
const editedIndex = ref(-1)
const headers = [
  { title: "Número", key: "numero" },
  { title: "Marca", key: "marca" },
  { title: "Modelo", key: "modelo" },
  { title: "Ano", key: "ano" },
  { title: "Status", key: "status" },
  { title: "Ações", key: "actions" },
]

const desserts = ref([])
const editedItem = ref({
  numero: '',
  marca: '',
  modelo: '',
  ano: '',
  status: 0,
})
const defaultItem = {
  numero: '',
  marca: '',
  modelo: '',
  ano: '',
  status: 0,
}

const formTitle = computed(() =>
  editedIndex.value === -1 ? 'Nova Bicicleta' : 'Editar Bicicleta'
)

function initialize() {
  desserts.value = getBicicletas();
}

function editItem(item) {
  editedIndex.value = desserts.value.indexOf(item)
  editedItem.value = { ...item }
  dialog.value = true
}

function deleteItem(item) {
  editedIndex.value = desserts.value.indexOf(item)
  editedItem.value = { ...item }
  dialogDelete.value = true
}

function deleteItemConfirm() {
  desserts.value.splice(editedIndex.value, 1)
  closeDelete()
}

function close() {
  dialog.value = false
  nextTick(() => {
    editedItem.value = { ...defaultItem }
    editedIndex.value = -1
  })
}

function closeDelete() {
  dialogDelete.value = false
  nextTick(() => {
    editedItem.value = { ...defaultItem }
    editedIndex.value = -1
  })
}

function save() {
  if (editedIndex.value > -1) {
    Object.assign(desserts.value[editedIndex.value], editedItem.value)
  } else {
    desserts.value.push({ ...editedItem.value })
  }
  close()
}

initialize()
</script>

<style scoped>
.div{
  width: 100%;
  display: flex;
  justify-content: center;
}
.data-table{
  padding: 0;
  margin: 0;
  border: none;
  width: 90%;
}
</style>