import { AbstractControl } from "@angular/forms";

export function hasExclamationMark(input:AbstractControl){
    const hasExclamation = input.value && input.value.indexOf('!') >= 0;
    return hasExclamation ? null: {needsExcalamation : true}

}