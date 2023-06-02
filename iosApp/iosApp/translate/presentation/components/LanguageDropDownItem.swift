//
//  LanguageDropDownItem.swift
//  iosApp
//
//  Created by Sahil Khan on 31/05/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LanguageDropDownItem: View {
    var language: UiLanguage
    var onClick: ()->Void
    var body: some View {
        Button(action:onClick){
            HStack{
                if let image = UIImage(named:language.language.langName.lowercased()){
                    Image(uiImage: image)
                        .resizable()
                        .frame(width: 40,height: 40)
                        .padding(.trailing,5)
                    Text(language.language.langName)
                        .foregroundColor(.textBlack)
                }
            }
        }
    }
}

struct LanguageDropDownItem_Previews: PreviewProvider {
    static var previews: some View {
        LanguageDropDownItem(
            language: UiLanguage(language: .hindi, imageName: "hindi"),
            onClick: {}
        )
    }
}
