import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ApiService, Country} from './api.service';
import {CountryService, CurrentCountryViewEnum} from './country.service';

@Injectable({
  providedIn: 'root'
})
export class RelationService {

  constructor(
    private http: HttpClient,
    private apiService: ApiService,
    private countryService: CountryService
  ) {
  }

  country1Name = '';
  relationArray: Array<Relation> = [];
  countryRelationsArray: Array<Relation> = [];
  countryRelationsArray1: Array<Relation> = [];
  countryRelationsArray2: Array<Relation> = [];

  currentView: any = CurrentReleationViewEnum.RELATIONDETAIL;

  getRelations(): void {
    this.apiService.getRelations().subscribe(value => {
      this.relationArray = value;
    });
  }

  displayCountryName(countryId: number): String {
    return this.countryService.countryArray.find(c => c.id === countryId).name;
  }

  displayRelationType(relation: Relation): String {
    if (relation.relationType === 1) {
      return 'Alliance';
    } else if (relation.relationType === 2) {
      return 'War';
    } else if (relation.relationType === 3) {
      return 'Non-Aggression-Pact';
    } else if (relation.relationType === 4) {
      return 'Trading';
    }
  }

  displayCountryRelations(country: Country): void {
    const c = this.countryService.countryArray.find(val => {
      return val.id === country.id;
    });
    this.country1Name = c.name;
    this.countryRelationsArray1 = this.relationArray.filter(val => val.countryId1 === c.id);
    this.countryRelationsArray2 = this.relationArray.filter(val => val.countryId2 === c.id);
    this.countryRelationsArray = this.countryRelationsArray1.concat(this.countryRelationsArray2);
  }

  createRelation(relation: Relation): void {
    this.apiService.createRelation(relation).subscribe(val => {
      this.getRelations();
    });
  }
}

export class Relation {
  id: number;
  countryId1: number;
  countryId2: number;
  relationType: number;

  constructor(id: number, countryId1: number, countryId2: number, relationType: number) {
    this.id = id;
    this.countryId1 = countryId1;
    this.countryId2 = countryId2;
    this.relationType = relationType;
  }
}

export enum CurrentReleationViewEnum {
  RELATIONDETAIL,
  RELATIONCREATE
}
